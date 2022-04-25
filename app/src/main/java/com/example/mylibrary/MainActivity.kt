package com.example.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvDisplay.text = MyLibrary().getSquare(5).toString()
        MyLibrary().setUpFlow()
        binding.button.setOnClickListener {
            MyLibrary().setupClick(binding.tvDisplay)
        }
    }
}