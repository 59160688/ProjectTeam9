package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Approve : AppCompatActivity() {
    private var btnapprove: Button? = null
    private var btn_notapprove: Button? = null
    private var br_no: TextView? = null
    private var ps_fname: TextView? = null
    private var brst_name: TextView? = null
    private var eqs_code_old: TextView? = null
    private var eqs_name: TextView? = null
    private var br_date : TextView? = null
    private var br_check_date : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_approve)
        btnapprove = findViewById(R.id.btnapprove) as Button
        btnapprove!!.setOnClickListener {
            val intent = Intent(this, Borrowlist::class.java)
            startActivity(intent)

        }
        btn_notapprove = findViewById(R.id.btnnotapprove) as Button
        btn_notapprove!!.setOnClickListener {
            val intent = Intent(this, NotApprove::class.java)
            startActivity(intent)

        }


        br_no =findViewById(R.id.id_ans) as TextView
        ps_fname = findViewById(R.id.name_ans) as TextView
        brst_name = findViewById(R.id.status_ans) as TextView
        eqs_code_old = findViewById(R.id.AstId_ans) as TextView
        eqs_name = findViewById(R.id.Astname_ans) as TextView
        br_date = findViewById(R.id.date_borrow_ans) as TextView
        br_check_date = findViewById(R.id.date_return_ans) as TextView

        var intent = getIntent()
        var ps_lname = intent.getStringExtra("ps_lname")
        br_no!!.setText(intent.getStringExtra("br_no"))
        ps_fname!!.setText(intent.getStringExtra("ps_fname")+" "+ps_lname)
        brst_name!!.setText(intent.getStringExtra("brst_name"))
        eqs_name!!.setText(intent.getStringExtra("eqs_name"))
        eqs_code_old!!.setText(intent.getStringExtra("eqs_code_old"))
        br_date!!.setText(intent.getStringExtra("br_date"))
        br_check_date!!.setText(intent.getStringExtra("br_check_date"))

    }
}
