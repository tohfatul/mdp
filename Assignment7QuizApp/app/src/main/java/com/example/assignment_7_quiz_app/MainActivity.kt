package com.example.assignment_7_quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        mNavController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, mNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp()
    }
}