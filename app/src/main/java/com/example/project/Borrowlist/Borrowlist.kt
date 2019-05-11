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
import org.json.JSONArray
import java.util.*



class Borrowlist : AppCompatActivity() {
    private var gotoborrow: Button? = null

    private var btnreturn: Button? = null
    private var btnapprove: Button? = null
    private var btndetail: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrowlist)
        gotoborrow = findViewById(R.id.btnborrow) as Button

        gotoborrow!!.setOnClickListener {
            val intent = Intent(this, Borrow::class.java)
            startActivity(intent)

        }
        btnreturn = findViewById(R.id.btnreturn) as Button

        btnreturn!!.setOnClickListener {
            val intent = Intent(this, Return::class.java)
            startActivity(intent)

        }
        btndetail = findViewById(R.id.btndetail) as Button

        btndetail!!.setOnClickListener {
            val intent = Intent(this, Detail::class.java)
            startActivity(intent)

        }
        btnapprove = findViewById(R.id.btnapprove) as Button

        btnapprove!!.setOnClickListener {
            val intent = Intent(this, Approve::class.java)
            startActivity(intent)

        }

    }
}



