package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
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

        btn_login.setOnClickListener{
            var username = txtEmail.text.toString()
            var passwordd = txtPassword.text.toString()
            var  isSuccessLogin = false

            var userFirstName = "";
            for (user in users)
            {
                if(username == user.username && passwordd == user.password)
                {

                    userFirstName = user.firstname;
                    isSuccessLogin = true
                    break
                }

            }

            if(isSuccessLogin)
            {

                var intent = Intent(this, ShoppingActivity::class.java)
                intent.putExtra("userFirstname", "Welcome, " + userFirstName)


                startActivity(intent)

            }
            else
            {
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }

        txtVCreateAccount.setOnClickListener{
            var intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)

        }
    }
}