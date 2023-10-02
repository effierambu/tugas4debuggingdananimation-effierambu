package com.pemrogramanAndroid.clickrush

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.PemrogramanAndroid.clickrush.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btTap.setOnClickListener {

        }

    }
}