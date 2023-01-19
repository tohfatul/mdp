package com.example.assignment_7_quiz_app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuizDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuiz(quiz: Quiz)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuizzes(vararg quiz: Quiz)

    @Query("SELECT * FROM quiz ORDER BY id")
    fun getAllQuizzes(): List<Quiz>

    @Delete
    suspend fun deleteQuiz(quiz: Quiz)

    @Query("DELETE FROM quiz WHERE 1=1")
    suspend fun deleteAllQuiz()
}