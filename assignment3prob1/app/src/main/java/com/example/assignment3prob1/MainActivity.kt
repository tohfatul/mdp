package com.example.assignment3prob1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cmdAdd.setOnClickListener{
            val tableRow = TableRow(this)
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)

            val txtViewAndroidVersion = TextView(this)
            txtViewAndroidVersion.text=txtAndroidVersion.text

            val txtViewAndroidCode = TextView(this)
            txtViewAndroidCode.text = txtViewAndroidCode.text



            tableRow.addView(txtViewAndroidVersion, 0)

            tableRow.addView(txtViewAndroidCode, 1)

            tableRow.setLayoutParams(layoutParams)

            myTable.addView(tableRow)
        }
    }
}