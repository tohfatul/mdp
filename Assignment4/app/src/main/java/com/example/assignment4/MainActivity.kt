package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import layout.User

class MainActivity : AppCompatActivity() {

    val users = mutableListOf(
        User("Milton", "Khandokar", "milton@gmail.com", "milton"),
        User("Liton", "Talukdar", "liton@gmail.com", "liton"),
        User("Titon", "Habildar", "titon@gmail.com", "titon"),
        User("Zayed", "Bandar", "zayed@gmail.com", "zayed"),
        User("Mahfuza", "Andor", "mahfuza@gmail.com", "mahfuza")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}