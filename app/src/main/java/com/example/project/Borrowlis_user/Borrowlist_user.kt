package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import kotlinx.android.synthetic.main.activity_borrowlist_user.*
import org.json.JSONArray

class Borrowlist_user : AppCompatActivity() {
   // private var gotoborrow: Button? = null
    private var btndetail: Button? = null

    val TAG = "SERVICE_ST"
    var requestQueue: RequestQueue? = null
    var List = ArrayList<Borrowlists>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrowlist_user)

        btnborrow!!.setOnClickListener {
            val intent = Intent(this, Borrow_user::class.java)
            startActivity(intent)

        }



        val textView = findViewById<TextView>(R.id.item)
        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val url = "http://10.70.20.169:8218/gbl"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            {
                    response ->

                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                (0 until json.length()).mapTo(List) {
                    Borrowlists(
                        json.getJSONObject(it).getString("br_no"),
                        json.getJSONObject(it).getString("ps_fname"),
                        json.getJSONObject(it).getString("ps_lname"),
                        json.getJSONObject(it).getString("br_date"),
                        json.getJSONObject(it).getString("br_check_date"),
                        json.getJSONObject(it).getString("brst_name"))

                }

                item_list.layoutManager = LinearLayoutManager(this)
               item_list.adapter = RecycleAdapter(this, List)
            },

            Response.ErrorListener { textView.text ="not work" }
        )
        stringRequest.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue?.add(stringRequest)

    }




    override fun onStop() {
        super.onStop()
        requestQueue?.cancelAll(TAG)
    }
}
