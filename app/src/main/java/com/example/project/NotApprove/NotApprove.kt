package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NotApprove : AppCompatActivity() {

    private var btnnotapprove: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_approve)
        btnnotapprove = findViewById(R.id.btnnotapprove) as Button
        btnnotapprove!!.setOnClickListener {
            val intent = Intent(this, Borrowlist::class.java)
            startActivity(intent)

        }

    }
}
