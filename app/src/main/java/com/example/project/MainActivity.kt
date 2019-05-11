package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var menuoffice: Button? = null
    private var menuuser: Button? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainmenu)
        menuoffice = findViewById(R.id.text_user2) as Button
        menuuser = findViewById(R.id.text_user1) as Button


        menuuser!!.setOnClickListener {
            val intent = Intent(this, Menuuser::class.java)
            startActivity(intent)

        }
        menuoffice!!.setOnClickListener {
            val intent = Intent(this, Menuoffice::class.java)

            startActivity(intent)

        }

    }
}

//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.support.v7.widget.LinearLayoutManager
//import android.widget.TextView
//import com.android.volley.Request
//import com.android.volley.RequestQueue
//import com.android.volley.Response
//import com.android.volley.toolbox.*
//import kotlinx.android.synthetic.main.activity_main.*
//import org.json.JSONArray
//
//class MainActivity : AppCompatActivity() {
//    val TAG = "SERVICE_ST"
//    var requestQueue: RequestQueue? = null
//    var BookList = ArrayList<Borrowlists>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val textView = findViewById<TextView>(R.id.simple)
//        // Instantiate the cache
//        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
//// Set up the network to use HttpURLConnection as the HTTP client.
//        val network = BasicNetwork(HurlStack())
//// Instantiate the RequestQueue with the cache and network. Start the queue.
//        val requestQueue = RequestQueue(cache, network).apply {
//            start()
//        }
//
//        val url = "http://10.70.20.66:8556/getall"
//        // Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener<String>
//            {
//                    response ->
//
//                // Display the first 500 characters of the response string.
//                val json = JSONArray(response)
//                (0 until json.length()).mapTo(BookList) {
//                    Borrowlists(
//                        json.getJSONObject(it).getString("br_no"),
//                        json.getJSONObject(it).getString("ps_fname"),
//                        json.getJSONObject(it).getString("ps_lname"))
//                }
//                //textView.text = "Response is: ${
//                //BookList[0].author
//                //}"
//                recycler_list.layoutManager = LinearLayoutManager(this)
//                recycler_list.adapter = RecycleAdapter(this, BookList)
//            },
//
//            Response.ErrorListener { textView.text = "That didn't work!" }
//        )
//        stringRequest.tag = TAG
//        // Add the request to the RequestQueue.
//        requestQueue?.add(stringRequest)
//
//    }
//    override fun onStop() {
//        super.onStop()
//        requestQueue?.cancelAll(TAG)
//    }
//}
