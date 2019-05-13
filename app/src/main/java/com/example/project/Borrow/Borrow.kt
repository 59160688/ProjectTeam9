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

        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.activity_borrow,null)

        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("validate",{ dialogInterface: DialogInterface, i: Int -> })
        val customDialog = dialog.create()
        customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
            if(name1.text.toString()==""){
                customDialog.dismiss()
            }else if(date.text.toString()==""){
                customDialog.dismiss()
            }else if(return_date.text.toString()==""){
                customDialog.dismiss()
            }else if(comment.text.toString()==""){
                customDialog.dismiss()
            }
        })
        customDialog.show()

      //  btnchooseformat = findViewById(R.id.btnchooseformat) as Button
       // btnchooseformat!!.setOnClickListener {
         //   val intent = Intent(this, Chooseformat::class.java)
           //     startActivity(intent)
            //}

        }

    }

