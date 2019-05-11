package com.example.project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Detail : AppCompatActivity() {

    private var br_no: TextView? = null
    private var ps_fname: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        br_no =findViewById(R.id.id_ans) as TextView
        ps_fname = findViewById(R.id.name_ans) as TextView

        var intent = getIntent()

        br_no!!.setText(intent.getStringExtra("br_no"))
        ps_fname!!.setText(intent.getStringExtra("ps_fname"))


    }
}
