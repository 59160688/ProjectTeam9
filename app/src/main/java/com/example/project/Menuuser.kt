package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menuuser : AppCompatActivity() {

    private var gotoborrow: Button? = null
//    private var gotohis: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuuser)
        gotoborrow = findViewById(R.id.text_user1) as Button

        gotoborrow!!.setOnClickListener {
            val intent = Intent(this, Borrowlist_user::class.java)
            startActivity(intent)

        }
//        gotohis = findViewById(R.id.text_his) as Button

//        gotohis!!.setOnClickListener {
//            val intent = Intent(this, MainHistory::class.java)
//            startActivity(intent)
//
//        }
    }
}
