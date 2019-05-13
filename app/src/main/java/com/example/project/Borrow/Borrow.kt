package com.example.project

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Borrow : AppCompatActivity() {

    private var btnchooseformat: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow)

        var name1 = findViewById<EditText>(R.id.editText_Name)
        var date = findViewById<EditText>(R.id.editText_Date)
        var return_date = findViewById<EditText>(R.id.editText_DateReturn)
        var comment = findViewById<EditText>(R.id.editText_Comment)






      //  btnchooseformat = findViewById(R.id.btnchooseformat) as Button
       // btnchooseformat!!.setOnClickListener {
         //   val intent = Intent(this, Chooseformat::class.java)
           //     startActivity(intent)
            //}

        }

    }

