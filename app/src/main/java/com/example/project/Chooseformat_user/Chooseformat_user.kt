package com.example.project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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
import java.util.ArrayList

class Chooseformat_user : AppCompatActivity() {

    val TAG = "SERVICE_ST"
    var List = ArrayList<Chooseformat_user_data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chooseformat_user)

        val textView = findViewById<TextView>(R.id.item)
        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val url = "http://10.80.84.85:8218/gbt"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            {
                    response ->

                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                (0 until json.length()).mapTo(List) {
                    Chooseformat_user_data(
                        json.getJSONObject(it).getString("fmst_name"))

                }

                item_list.layoutManager = LinearLayoutManager(this)
                item_list.adapter = ChooseformatUserAdapter(this, List)
            },

            Response.ErrorListener { textView.text ="not work" }
        )
        stringRequest.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue?.add(stringRequest)
    }
}
