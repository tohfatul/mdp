package com.example.assignment_7_quiz_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class ScoreFragment : Fragment() {

    private lateinit var tvScore: TextView
    private lateinit var btnResult: Button
    private lateinit var btnTryAgain: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_score, container, false)
        tvScore = view.findViewById(R.id.tv_score)
        val score = ScoreFragmentArgs.fromBundle(requireArguments()).scoress
        val answers = ScoreFragmentArgs.fromBundle(requireArguments()).answerss
        val wrongAnswers = 15 - score
        val finalScore = "$score/15"
        val scoreResult = String.format(
            "Total Questions: 15\n\nCorrect Answers(Score): %d\n\nWrong Answer: %d\n\nYour Score is: %s",
            score, wrongAnswers, finalScore
        )
        tvScore.text = scoreResult
        btnResult = view.findViewById(R.id.btn_result_analysis)
        btnTryAgain = view.findViewById(R.id.btn_try_again)
        btnTryAgain.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_resultFragment_to_questionFragment)
        }
        btnResult.setOnClickListener {
            val action = ScoreFragmentDirections.actionResultFragmentToAnalysisFragment(answers)
            Navigation.findNavController(requireView()).navigate(action)
        }
        return view
    }


}