package com.practice.hiltpractice.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.hiltpractice.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, LandingFragment.instance("HiltPractice"))
            .commit()
    }
}