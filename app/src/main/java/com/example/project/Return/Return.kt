package com.example.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.*
import org.json.JSONObject

class Return : AppCompatActivity() {

    private var requestQueue: RequestQueue? = null
    private var br_no: TextView? = null
    private var ps_fname: TextView? = null
    private var brst_name: TextView? = null
    private var eqs_code_old: TextView? = null
    private var eqs_name: TextView? = null
    private var br_date : TextView? = null
    private var br_check_date : TextView? = null
    private var btnapprove: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        btnapprove = findViewById(R.id.btnapprove) as Button
        btnapprove!!.setOnClickListener {
            val intent = Intent(this, Returnchoosename::class.java)
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



        val cache = DiskBasedCache(cacheDir,1024 * 1024)
        val network = BasicNetwork(HurlStack())

        requestQueue = RequestQueue(cache,network).apply {
            start()
        }

        requestQueue = Volley.newRequestQueue(this)

        btnapprove = findViewById(R.id.btnapprove) as Button
        btnapprove!!.setOnClickListener {
            update1(br_no,object :VolleyCallback_return{
                override fun onSuccess(result: String) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSuccess(result: JSONObject) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            val toast = Toast.makeText(this, "update1", Toast.LENGTH_LONG)

            toast.show()


        }

    }

    fun update1(br_no: TextView?,callback: VolleyCallback_return){
        val url = ""
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


    fun update2(eqs_id: TextView?,callback: VolleyCallback_return){
        val url = ""
        val jsonBody = JSONObject()
        jsonBody.put("eqs_id",eqs_id!!.text)
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

//    private var btnapprove: Button? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_return)
//        btnapprove = findViewById(R.id.btnapprove) as Button
//
//        btnapprove!!.setOnClickListener {
//            val intent = Intent(this, Returnchoosename::class.java)
//            startActivity(intent)
//
//        }
//    }
//}
