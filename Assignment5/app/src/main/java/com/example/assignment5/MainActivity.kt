package com.example.assignment5

import android.icu.text.DateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener {
            var  score = 0;


            if(radioBtnEast.isChecked)
                score += 50

            if(chkHydrogen.isChecked && chkOxygen.isChecked)
                score +=50

            var builder = AlertDialog.Builder(this)
            builder.setTitle("Information")
            builder.setIcon(R.drawable.info)
            var messagee = "";
            if (score>=50)
            {
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

                messagee="Congratulations! You submitted on " +
                        LocalDateTime.now().format(formatter) +
                        ". You achieved " + score + "%"


            }
            else
            {
                messagee = "Sorry to say that you could not pass!"
            }

            builder.setMessage(messagee)

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

        btnReset.setOnClickListener {
            radioBtnEast.isChecked=false
            radioBtnWest.isChecked=false
            radioBtnNorth.isChecked=false

            chkHydrogen.isChecked=false
            chkOxygen.isChecked=false
            chkNitrogen.isChecked=false


        }
    }
}