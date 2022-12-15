package com.example.assignment_6_cvbulder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import layout.User

class MainActivity : AppCompatActivity() {
    val users = mutableListOf(
        User("Tohfatul", "Islam", "tohfatul@gmail.com", "milton"),
        User("Liton", "Talukdar", "liton@gmail.com", "liton"),
        User("Titon", "Habildar", "titon@gmail.com", "titon"),
        User("Zayed", "Bandar", "zayed@gmail.com", "zayed"),
        User("Mahfuza", "Andor", "mahfuza@gmail.com", "mahfuza")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = edTxtUserName.text.toString()
        var password = edTxtPassword.text.toString()
        var userFirstName = ""
        btnLogin.setOnClickListener {
            var username = edTxtUserName.text.toString()
            var passwordd = edTxtPassword.text.toString()
            var isSuccessLogin = false

            for (user in users) {
                if (username == user.username && passwordd == user.password) {

                    userFirstName = user.firstname
                    isSuccessLogin = true
                    break
                }

            }

            if (isSuccessLogin) {

                var intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("userFirstName", "Welcome, " + userFirstName)


                startActivity(intent)

            } else {
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}