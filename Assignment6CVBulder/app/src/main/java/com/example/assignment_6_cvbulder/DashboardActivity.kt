package com.example.assignment_6_cvbulder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var sintent = intent
        var firstName =sintent.getStringExtra("userFirstName")


        val adapter = MyAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter=adapter
        TabLayoutMediator(tabLayout, viewPager){tab, position->

            when (position){
                0->{
                    tab.text="Home"
                }
                1->{
                    tab.text="About Me"
                }
                2->{
                    tab.text="Work"
                }
                3->{
                    tab.text="Contact"
                }
            }
        }.attach()

    }
}