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
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_borrowlist_user.*
import org.json.JSONArray

class MainHistory : AppCompatActivity() {
    private var btndetail: Button? = null
    val TAG = "SERVICE_ST"
    var List = ArrayList<MainHis>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_history)


        val textView = findViewById<TextView>(R.id.item)
        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val url = "http://10.80.79.182:8218/get_all"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            {
                    response ->

                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                (0 until json.length()).mapTo(List) {
                    MainHis(
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
                item_list.adapter = MainHistoryAdapter(this, List)
            },

            Response.ErrorListener { textView.text ="not work" }
        )
        stringRequest.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue?.add(stringRequest)

    }

}