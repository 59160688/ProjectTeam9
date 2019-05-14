package com.example.project

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

class NotApprove : AppCompatActivity() {
    private var requestQueue: RequestQueue? = null
    private var btnnotapprove: Button? = null
    private var br_no: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_approve)

        br_no = findViewById(R.id.br_no) as TextView

        var intent = getIntent()
        br_no!!.setText(intent.getStringExtra("br_no"))

        val cache = DiskBasedCache(cacheDir,1024 * 1024)
        val network = BasicNetwork(HurlStack())

        requestQueue = RequestQueue(cache,network).apply {
            start()
        }

        requestQueue = Volley.newRequestQueue(this)

        btnnotapprove = findViewById(R.id.btnnotapprove) as Button

        btnnotapprove!!.setOnClickListener {
            update(br_no,object : VolleyCallback{
                override fun onSuccess(result: String) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSuccess(result: JSONObject) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            val intent = Intent(this, Borrowlist::class.java)
            startActivity(intent)

        }




    }
    private fun update(br_no: TextView?, callback: VolleyCallback){
        val url = "http://10.80.79.182:8218/update_borrow_not_approve"
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
