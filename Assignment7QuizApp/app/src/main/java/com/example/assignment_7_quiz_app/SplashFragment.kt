package com.example.assignment_7_quiz_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assignment_7_quiz_app.data.Quiz
import com.example.assignment_7_quiz_app.data.QuizDb
import com.example.assignment_7_quiz_app.data.QuizViewModel
import com.example.assignment_7_quiz_app.databinding.FragmentSplashBinding
import com.example.assignment_7_quiz_app.utils.BaseFragment
import kotlinx.coroutines.launch


class SplashFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashBinding

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        binding.apply {


            btnGetStarted.setOnClickListener {



                val directions = SplashFragmentDirections.actionSplashFragmentToQuestionFragment()
                findNavController().navigate(directions)
            }


        }
        PrepareQuestions()
        return  binding.root
    }

    fun PrepareQuestions(){
        val q1 = Quiz(0,"1) Does Kotlin support primitive Datatypes?","A. Yes", "B. No","C. Can be Yes or No","D. Can not say","a","Answer: (b) No\n" +
                "\n" +
                "No, Kotlin does not provide support for primitive Data types like in Java.")
        val q2 = Quiz(0,"2) What is an immutable variable?", "A. A variable that can be changed","B. A variable used for string interpolation","C. A variable that cannot change, read-only","D. None of the above","c","Answer: (c) A variable that cannot change, read-only\n" +
                "\n" +
                "Explanation: Immutable variable are a variable that cannot change, it is read-only.")
        val q3 = Quiz(0,"3) Can we migrate code from Java to Kotlin?","A. Yes", "B. No","C. Can be Yes or No","D. Can not say","a","Answer: (a) Yes\n" +
                "\n" +
                "Explanation: JetBrains IDEA provides an inbuilt tool to migrate code from java to Kotlin.")
        val q4 = Quiz(0,"4) All classes in Kotlin classes are by default?","A. Public", "B. Sealed","C. Abstract","D. Final","d","Answer: (d) Final\n" +
                "\n" +
                "Explanation: All classes are final in Kotlin classes are by default")
        val q5 = Quiz(0,"5) Which file extension is used to save Kotlin files?","A. .java", "B. .kot","C. .kt","D. None of the above","c","Answer: (c) .kt\n" +
                "\n" +
                "Explanation: .kt or .kts extension is used to save Kotlin files.")
        val q6 = Quiz(0,"6) Which helps to iterate through a range?","A. And operator", "B. Ranges operator","C. Or operator","D. Conditional operator","b","Answer: (b) Ranges operator\n" +
                "\n" +
                "Explanation: Ranges operator helps to iterate through a range. Its operator form is (..)")
        val q7 = Quiz(0,"7) Elvis Operator is used for handling null expectations in Kotlin.","A. True", "B. False","C. Can be true or false","D. Can not say","a","Answer: (a) True\n" +
                "\n" +
                "Explanation: Elvis Operator is used for handling null expectations in Kotlin.")
        val q8 = Quiz(0,"8) Which of th following is used to compare two strings in Kotlin?","A. Using == operator", "B. Using compareTo() extension function","C. Both A and B","D. None of the above","c","Answer: (c) Both A and B\n" +
                "\n" +
                "Explanation: Both A and B is used to compare two strings in Kotlin.")
        val q9 = Quiz(0,"9) What is the syntax for declaring a variable as volatile in Kotlin?","A. var x: Long? = null", "B. Volatile var x: Long?","C. Volatile var x","D. Volatile var x: Long? = null","d","Answer: (d) Volatile var x: Long? = null\n" +
                "\n" +
                "Explanation: The syntax for declaring a variable as volatile in Kotlin is Volatile var x: Long? = null")
        val q10 = Quiz(0,"10) In Kotlin, ____________ is used when you know what functionalities a class should have.","A. exception class", "B. inheritance class","C. abstraction class","D. None of the above","c","Answer: (c) abstraction class\n" +
                "\n" +
                "Explanation: Abstraction is the most important concept of Objected Oriented Programming. In Kotlin, abstraction class is used when you know what functionalities a class should have.")
        val q11 = Quiz(0,"11) Is there any Ternary Conditional Operator in Kotlin like in Java?","A. True", "B. False","C. Can be true or false","D. Can not say","b","Answer: (b) false\n" +
                "\n" +
                "Explanation: There is no ternary conditional operator in Kotlin language.")
        val q12 = Quiz(0,"12) What is the use of data class in Kotlin?","A. extract the basic data types", "B. delete the basic data types","C. present the basic data types","D. holds the basic data types","d","Answer: (d) holds the basic data types\n" +
                "\n" +
                "Explanation: Data class holds the basic data types. It does not contain any functionality.")
        val q13 = Quiz(0,"13) Which of the following is Use for reading contents of file to ByteArray?","A. bufferedReader()", "B. readText()","C. readBytes()","D. readLines()","c","Answer: (c) readBytes()\n" +
                "\n" +
                "Explanation: readBytes() is the extension methods Kotlin provides to java.io.File which is used for reading contents of file to ByteArray.")
        val q14 = Quiz(0,"14) How many types of constructors available in Kotlin?",
            "A. 1", "B. 2","C. 3","D. 4","b","Answer: (b) 2\n" +
                    "\n" +
                    "Explanation: Two types of constructors available in Kotlin are: Primary constructor and Secondary constructor.")
        val q15 = Quiz(0,"15) How can you declare a variable in Kotlin?","A. value my_var: Char", "B. value Char : my_var","C. my_var: Char","D. value my_var: Char","d","Answer: (d) value my_var: Char\n" +
                "\n" +
                "Explanation: You declare a variable in Kotlin value my_var: Char.")


        launch {
            context?.let {
                quizViewModel.deleteAllQuiz()

                quizViewModel.addManyQuizzes(q1,q2,q3,q4,q5,q6,q7,q8,
                    q9,q10,q11,q12,q13,q14,q15)


            }
        }
    }

}