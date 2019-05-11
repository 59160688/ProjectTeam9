package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Borrow : AppCompatActivity() {

    private var btnchooseformat: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow)
        btnchooseformat = findViewById(R.id.btnchooseformat) as Button
        btnchooseformat!!.setOnClickListener {
            val intent = Intent(this, Chooseformat::class.java)
            startActivity(intent)

        }
    }
}
