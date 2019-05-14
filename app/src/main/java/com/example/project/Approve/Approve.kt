package com.example.project

import android.app.DownloadManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

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
            update()
            val toast = Toast.makeText(this, "update", Toast.LENGTH_LONG)

            toast.show()
//            val intent = Intent(this, Borrowlist::class.java)
//            startActivity(intent)
//

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
    fun update(){
        val url = "http://10.80.79.182:8218/update_borrow_approve"
        val jsonBody = JSONObject()
        jsonBody.put("br_no",br_no)
        // Request a string response from the provided URL.
        val stringRequest = JsonObjectRequest(
            Request.Method.PUT, url,jsonBody,
            Response.Listener<JSONObject> { response ->
                Toast.makeText(this, "${response}", Toast.LENGTH_SHORT).show()

            },
            Response.ErrorListener {
                    response-> Toast.makeText(this, "${response}", Toast.LENGTH_SHORT).show()
            }
        )
    }

}
