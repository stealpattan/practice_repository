package com.practice.sho_ma.practice_application

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.os.AsyncTask
import android.view.Menu
import android.view.MenuItem
//add library
import android.widget.*
//http connection
import okhttp3.*
//JSON
import org.json.JSONObject
import org.json.JSONArray

import android.util.Log

open class MyAsyncTask:AsyncTask<Void,Void,String>(){
    override fun doInBackground(vararg param: Void):String?{
        return null
    }
    override fun onPostExecute(text:String){}
}

class MainActivity : ActionBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testbutton = findViewById(R.id.testbutton) as Button
        val testtext = findViewById(R.id.testtext) as TextView

        testbutton.setOnClickListener{
            v->
            object:MyAsyncTask(){
                override fun doInBackground(vararg param: Void):String?{
                    return run()
                }
                override fun onPostExecute(text:String){
                    //testtext.setText(text)
                    try{
                        var jsonarray = JSONArray(text) as JSONArray
                        var jsonobj = jsonarray.getJSONObject(0) as JSONObject
                        var jsonstr = jsonobj.getString("id")
                        testtext.setText(jsonstr)
                    }catch(e: Exception){
                        testtext.setText("error" + e)
                        Log.e("error","error",e)
                    }
                }
            }.execute()
        }
    }
    fun makeToast(massage: String){
        val toast = Toast.makeText(this, massage, Toast.LENGTH_SHORT)
        toast.show()
    }
    //http connection function
    fun run():String?{
        try{
            val client = OkHttpClient() as OkHttpClient
            val req = Request.Builder().url("http://ytrw3xix.0g0.jp/app2017/feed").get().build()
            val res = client.newCall(req).execute()
            return res.body()?.string()
        }catch(e: Exception){
            return "error"
        }
    }
}