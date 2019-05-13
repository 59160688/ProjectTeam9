package com.example.project

import org.json.JSONObject

interface VolleyCallback {
    fun onSuccess(result: String)
    fun onSuccess(result: JSONObject)
}