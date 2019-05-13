package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
 import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_borrowlist_user.*
import org.json.JSONArray
import java.util.*



class Borrowlist : AppCompatActivity() {
    private var gotoborrow: Button? = null
    private var btnreturn: Button? = null
    private var btnapprove: Button? = null
    private var btndetail: Button? = null
    val TAG = "SERVICE_ST"
    var List = ArrayList<Borrowlist_data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrowlist)
        gotoborrow = findViewById(R.id.btnborrow) as Button
        gotoborrow!!.setOnClickListener {
            val intent = Intent(this, Borrow::class.java)
            startActivity(intent)

        }
//        btnreturn = findViewById(R.id.btnreturn) as Button
//        btnreturn!!.setOnClickListener {
//            val intent = Intent(this, Return::class.java)
//            startActivity(intent)
//
//        }
//        btndetail = findViewById(R.id.btndetail) as Button
//
//        btndetail!!.setOnClickListener {
//            val intent = Intent(this, Detail::class.java)
//            startActivity(intent)
//
//        }
//        btnapprove = findViewById(R.id.btnapprove) as Button
//
//        btnapprove!!.setOnClickListener {
//            val intent = Intent(this, Approve::class.java)
//            startActivity(intent)
//
//        }
        val textView = findViewById<TextView>(R.id.item)
        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val url = "http://10.80.77.146:8218/getall"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            {
                    response ->

                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                (0 until json.length()).mapTo(List) {
                    Borrowlist_data(
                        json.getJSONObject(it).getString("br_no"),
                        json.getJSONObject(it).getString("ps_fname"),
                        json.getJSONObject(it).getString("ps_lname"),
                        json.getJSONObject(it).getString("br_date"),
                        json.getJSONObject(it).getString("br_check_date"),
                        json.getJSONObject(it).getString("brst_name"),
                        json.getJSONObject(it).getString("eqs_code_old"),
                        json.getJSONObject(it).getString("eqs_name"))

                }

                item_list.layoutManager = LinearLayoutManager(this)
                item_list.adapter = BorrowlistAdapter(this, List)
            },

            Response.ErrorListener { textView.text ="not work" }
        )
        stringRequest.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue?.add(stringRequest)


    }
}



