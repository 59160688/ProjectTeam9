package com.example.project

import android.app.DownloadManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import org.json.JSONObject
import java.util.*

class Approve : AppCompatActivity() {

    private var requestQueue: RequestQueue? = null
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

        val cache =DiskBasedCache(cacheDir,1024 * 1024)
        val network =BasicNetwork(HurlStack())

        requestQueue = RequestQueue(cache,network).apply {
            start()
        }

        requestQueue = Volley.newRequestQueue(this)

        btnapprove = findViewById(R.id.btnapprove) as Button
        btnapprove!!.setOnClickListener {
            update(br_no,object :VolleyCallback{
                override fun onSuccess(result: String) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSuccess(result: JSONObject) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            val toast = Toast.makeText(this, "update1", Toast.LENGTH_LONG)

            toast.show()

//            val intent = Intent(this, Borrowlist::class.java)
//            startActivity(intent)

        }
        btn_notapprove = findViewById(R.id.btnnotapprove) as Button
        btn_notapprove!!.setOnClickListener {
                val intent = Intent(this, NotApprove::class.java)
                intent .putExtra("br_no",br_no!!.text.toString())
                startActivity(intent)
        }




    }



    fun update(br_no: TextView?,callback: VolleyCallback){
        val url = "http://10.80.84.85:8218/update_borrow_approve"
        val jsonBody = JSONObject()
        jsonBody.put("br_no",br_no!!.text)
        val stringRequest = JsonObjectRequest(
            Request.Method.PUT, url,jsonBody,
            Response.Listener<JSONObject> { response ->
                //val accounting = JSONArray(response)
                callback.onSuccess(response)
            },
            Response.ErrorListener {
                    response-> Toast.makeText(this, "${response}", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue?.add(stringRequest)
    }


}