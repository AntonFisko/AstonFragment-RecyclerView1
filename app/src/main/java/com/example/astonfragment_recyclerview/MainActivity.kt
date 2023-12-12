package com.example.fragmentaston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentaston.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragmentTwoButtons = FragmentTwoButtons()

            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragmentTwoButtons)
                .commit()
        }
    }
}