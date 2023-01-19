package com.example.assignment_7_quiz_app.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuizViewModel(application:Application):AndroidViewModel(application) {

    val readAllData : List<Quiz>
    private val repository : QuizRepository
    init {
        val quizDao = QuizDb.getDatabase(application).quizDao()
        repository = QuizRepository(quizDao)
        readAllData = repository.readAllQuizzes
    }

    fun  addQuiz(quiz:Quiz){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addQuiz(quiz)
        }
    }

    fun  addManyQuizzes(vararg quiz:Quiz){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addQuizzes(*quiz)
        }
    }
    fun  deleteAllQuiz(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}