package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menuoffice : AppCompatActivity() {
    private var gotoborrow: Button? = null
    private var btndack: Button? = null
    private var gotohis: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuoffice)
        gotoborrow = findViewById(R.id.text_user1) as Button
        btndack = findViewById(R.id.btndack) as Button

        gotoborrow!!.setOnClickListener {
            val intent = Intent(this, Borrowlist::class.java)
            startActivity(intent)

        }
        btndack!!.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
                gotohis = findViewById(R.id.text_his) as Button

        gotohis!!.setOnClickListener {
            val intent = Intent(this, MainHistory::class.java)
            startActivity(intent)

        }
    }
}
