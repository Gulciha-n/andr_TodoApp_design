package com.example.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this = MainActivity (bulunduğu class)
        setContentView(R.layout.activity_main)
        //R , kodlama içinde res klasörünü temsil eder.
        //@, xml içinde res klasörünü temsil eder.
    }
}