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

class Chooseasset_user : AppCompatActivity() {


    val TAG = "SERVICE_ST"
    var requestQueue: RequestQueue? = null
    var Data = ArrayList<Chooseasset_user_data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooseasset_user)

        var intent = getIntent()
        var fmst_id = intent.getStringExtra("fmst_id")

        val textView = findViewById<TextView>(R.id.textlist1)

        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val url = "http://10.70.20.169:8218/gbe/"+fmst_id
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String>
            {
                    response ->

                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Data) {
                    Chooseasset_user_data(
                        json.getJSONObject(it).getString("eqs_code_old"),
                        json.getJSONObject(it).getString("eqs_name"))
                }

                item_list.layoutManager = LinearLayoutManager(this)
                item_list.adapter = ChooseassetUserAdapter(this, Data)
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
