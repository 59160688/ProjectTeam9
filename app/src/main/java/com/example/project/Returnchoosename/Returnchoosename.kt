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
import org.w3c.dom.Text

class Returnchoosename : AppCompatActivity() {

    private var requestQueue: RequestQueue? = null
    private var btnconre: Button? = null
    private var br_no: TextView? = null
    private var br_cm_no_allowed:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_returnchoosename)

        val cache = DiskBasedCache(cacheDir,1024 * 1024)
        val network = BasicNetwork(HurlStack())

        requestQueue = RequestQueue(cache,network).apply {
            start()
        }

        requestQueue = Volley.newRequestQueue(this)

        btnconre = findViewById(R.id.btnconre) as Button
        br_no = findViewById(R.id.br_no) as TextView
        br_cm_no_allowed = findViewById(R.id.editText_Name)as EditText
        var intent = getIntent()
        br_no!!.setText(intent.getStringExtra("br_no"))

        btnconre!!.setOnClickListener {
            update(br_no,br_cm_no_allowed,object :VolleyCallback{
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

    fun update(br_no: TextView?,br_cm_no_allowed: TextView?,callback: VolleyCallback){
        val url = "http://10.80.79.182:8218/update_borrow_return"
        val jsonBody = JSONObject()
        jsonBody.put("br_no",br_no!!.text)
        jsonBody.put("br_cm_no_allowed",br_cm_no_allowed!!.text)
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
