package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConfrimBorrow : AppCompatActivity() {

    private var btnconfirm: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confrim_borrow)
        btnconfirm = findViewById(R.id.btnborrow) as Button
        btnconfirm!!.setOnClickListener {
            val intent = Intent(this, Borrowlist::class.java)
            startActivity(intent)

        }
    }
}
