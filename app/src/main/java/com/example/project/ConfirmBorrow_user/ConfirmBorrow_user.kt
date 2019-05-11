package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConfirmBorrow_user : AppCompatActivity() {
    private var btnconfirm: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_borrow_user)
        btnconfirm = findViewById(R.id.btnborrow) as Button
        btnconfirm!!.setOnClickListener {
            val intent = Intent(this, Borrowlist_user::class.java)
            startActivity(intent)

        }
    }
}
