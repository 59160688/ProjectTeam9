package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Return : AppCompatActivity() {

    private var btnapprove: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        btnapprove = findViewById(R.id.btnapprove) as Button

        btnapprove!!.setOnClickListener {
            val intent = Intent(this, Returnchoosename::class.java)
            startActivity(intent)

        }
    }
}