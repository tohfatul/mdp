package com.example.assignment_7_quiz_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.assignment_7_quiz_app.data.Quiz
import com.example.assignment_7_quiz_app.data.QuizDb
import com.example.assignment_7_quiz_app.data.QuizViewModel
import com.example.assignment_7_quiz_app.utils.BaseFragment
import kotlinx.coroutines.launch
import com.example.assignment_7_quiz_app.utils.AppUtils.*
import com.example.assignment_7_quiz_app.utils.toast
import kotlinx.android.synthetic.main.fragment_score.*


class QuestionFragment : BaseFragment() {


    private lateinit var tvQuestion: TextView
    private lateinit var tvScore: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var questions: List<Quiz>
    private var qstnIdx = 0
    private var homeViewModel: HomeViewModel? = null
    private var selectedChoice: String? = null
    private var answers: MutableList<String> = mutableListOf()
    private lateinit var currentQuiz: Quiz
    private var isFirstTime = true

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_question, container, false)

        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        val skipBtn = view.findViewById<Button>(R.id.btn_qstn_skip)
        val nextBtn = view.findViewById<Button>(R.id.btn_qstn_next)
        tvQuestion = view.findViewById(R.id.tv_question)
        tvScore = view.findViewById(R.id.tv_score)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val scoreLiveData: MutableLiveData<Int> = homeViewModel!!.getInitialScore()
        scoreLiveData.observe(viewLifecycleOwner) {
            tvScore.text = String.format("%d/15", it)
        }
        launch {
            context?.let {
                //questions = QuizDb(it).quizDao().getAllQuizzes()
                    questions = quizViewModel.readAllData

                changeQuestion(view)
            }
        }

        skipBtn.setOnClickListener {
            changeQuestion(view)
        }
        nextBtn.setOnClickListener {
            if (selectedChoice != null){
                evaluateAnswer(selectedChoice!!)
                changeQuestion(view)
            } else context?.toast(getString(R.string.please_provide_answer_toast_message))

        }
        radioGroup = view.findViewById(R.id.question_radio)
        radioGroup.setOnCheckedChangeListener(this::handler)

        return view
    }

    private fun changeQuestion(view:View) {
        if(!isFirstTime){
            val selectedAns = if(selectedChoice!=null) selectedChoice else ""
            answers.add(selectedAns!!)
        }
        isFirstTime = false
        if (qstnIdx == 15) {
            val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(
                homeViewModel?.getFinalScore()?.value!!, answers.toTypedArray()
            )
            Navigation.findNavController(requireView()).navigate(action)
            return
        }
        currentQuiz = questions[qstnIdx]
        tvQuestion.text = currentQuiz.question
        val radioGroup = view.findViewById(R.id.question_radio) as RadioGroup
        val questionChoices = listOf(currentQuiz.a, currentQuiz.b, currentQuiz.c, currentQuiz.d)
        for (i in 0 until radioGroup.childCount) {
            (radioGroup.getChildAt(i) as RadioButton).text = questionChoices[i]
        }
        qstnIdx++
        selectedChoice = null
        radioGroup.clearCheck()
        title.text = "Quiz-" + qstnIdx
    }

    private fun handler(group: RadioGroup, checkedId: Int) {
        when (checkedId) {
            R.id.radio_q1_a -> selectedChoice = AnswerChoice.A.value
            R.id.radio_q1_b -> selectedChoice = AnswerChoice.B.value
            R.id.radio_q1_c -> selectedChoice = AnswerChoice.C.value
            R.id.radio_q1_d -> selectedChoice = AnswerChoice.D.value
        }
    }

    private fun evaluateAnswer(ans: String) {
        if (currentQuiz.answer == ans) {
            homeViewModel!!.getCurrentScore()
        }
    }

}