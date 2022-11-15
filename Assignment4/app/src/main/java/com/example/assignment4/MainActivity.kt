package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import layout.User

class MainActivity : AppCompatActivity() {

    val users = mutableListOf(
        User("kidus", "tekeste", "ktekeste@miu.com", "kiduspass"),
        User("Bernard", "Arnault", "barnault@miu.com", "bernardpass"),
        User("Bill", "Gates", "bgates@miu.com", "billpass"),
        User("Larry", "Page", "lpage@miu.com", "larrypass"),
        User("Warren", "Buffett", "wbuffett@miu.com", "warrenpass")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}