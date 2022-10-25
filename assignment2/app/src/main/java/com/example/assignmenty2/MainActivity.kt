package com.example.assignmenty2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private var listOfFood: ArrayList<String> = ArrayList<String>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfFood.add("Hamburger")
        listOfFood.add("Pizza")
        listOfFood.add("Mexican")
        listOfFood.add("American")
        listOfFood.add("Chinese")

    }

    fun decide(view : View) {
        var textListRandom: TextView = findViewById<TextView>(R.id.textView2)

        textListRandom.text = listOfFood[Random.nextInt(0, listOfFood.size)]
    }

    fun addFood(view : View) {
        var textAdd: TextView = findViewById<TextView>(R.id.editTextTextPersonName)
        var textListRandom: TextView = findViewById<TextView>(R.id.textView2)

        listOfFood.add(textAdd.text.toString())

        textListRandom.text = textAdd.text
        textAdd.text = ""
    }
}