package com.example.assignment_7_quiz_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "quiz")
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val question: String,
    val a: String,
    val b: String,
    val c: String,
    val d: String,
    val answer: String,
    val explanation: String
): Serializable