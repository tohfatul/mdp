package com.example.assignment_7_quiz_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import com.example.assignment_7_quiz_app.data.Quiz
import com.example.assignment_7_quiz_app.data.QuizViewModel
import com.example.assignment_7_quiz_app.utils.BaseFragment
import kotlinx.coroutines.launch


class AnalysisFragment : BaseFragment() {

    private lateinit var questions: List<Quiz>

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_analysis, container, false)
        val listView = view.findViewById<ListView>(R.id.list_view)
        val answers = AnalysisFragmentArgs.fromBundle(requireArguments()).answers

        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        launch {
            context?.let {
                questions = quizViewModel.readAllData

                questions.forEach{ q ->
                    q.answer
                }
                listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,
                    prepResultAnalysis(questions, answers.toList()))
            }
        }

        return view
    }


    private fun prepResultAnalysis(questions: List<Quiz>, answers: List<String>): List<String> {
        val items = mutableListOf<String>()
        questions.forEachIndexed { index, quiz ->
            val listItem = String.format("%s\nYour answer: %s\nCorrect answer: %s",quiz.question,answers[index],quiz.explanation)
            items.add(listItem)
        }
        return items
    }
}