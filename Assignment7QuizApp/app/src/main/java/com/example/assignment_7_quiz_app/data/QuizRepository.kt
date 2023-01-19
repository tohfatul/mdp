package com.example.assignment_7_quiz_app.data

import androidx.lifecycle.LiveData

class QuizRepository(private val quizDao: QuizDao) {

    val readAllQuizzes: List<Quiz> = quizDao.getAllQuizzes()

    suspend fun addQuiz(quiz:Quiz){
        quizDao.addQuiz(quiz)
    }

    suspend fun addQuizzes(vararg quiz:Quiz){
        quizDao.addQuizzes(*quiz)
    }
    suspend fun deleteAll(){
        quizDao.deleteAllQuiz()
    }
}