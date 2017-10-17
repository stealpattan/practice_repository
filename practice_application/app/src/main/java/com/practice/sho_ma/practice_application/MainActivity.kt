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
import java.net.URL
import java.net.HttpURLConnection
//java io
import java.io.InputStream
//JSON
import org.json.JSONObject
import org.json.JSONArray
//Bitmap
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.util.Log

open class MyAsyncTask:AsyncTask<Void,Void,String>(){
    override fun doInBackground(vararg param: Void):String?{
        return null
    }
    override fun onPostExecute(text:String){}
}
open class subtask:AsyncTask<Void,Void,Bitmap>(){
    override fun doInBackground(vararg param: Void):Bitmap?{
        return null
    }
    override fun onPostExecute(pic: Bitmap){}
}


class MainActivity : ActionBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testbutton = findViewById(R.id.testbutton) as Button
        val testtext = findViewById(R.id.testtext) as TextView
        val imgv = findViewById(R.id.imgv) as ImageView

        testbutton.setOnClickListener{
            v->
            try {
                testtext.setText("button is bushed")
                object : subtask() {
                    override fun doInBackground(vararg param: Void): Bitmap? {
                        return runPic("")
                    }

                    override fun onPostExecute(pic: Bitmap) {
                        imgv.setImageBitmap(pic)
                    }
                }.execute()
            }catch(e:Exception){
                Log.e("error","error",e)
            }
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
    fun runPic(url: String):Bitmap?{
        try{
            val client = OkHttpClient() as OkHttpClient
            val req = Request.Builder().url("http://tpumarker.net/wp-content/uploads/2017/03/IMG_1348-768x512.jpg").get().build()
            val res = client.newCall(req).execute()
            val bitmap = BitmapFactory.decodeStream(res.body()?.byteStream())
            return bitmap
        }catch(e: Exception){
            return null
        }
    }
    fun http():Bitmap?{
        try{
            val url = URL("http://tpumarker.net/wp-content/uploads/2017/03/IMG_1348-768x512.jpg") as URL
            val connector = url.openConnection() as HttpURLConnection
            connector.setReadTimeout(10000);
            connector.setConnectTimeout(20000);
            connector.setRequestMethod("GET")
            connector.connect()
            var res = connector.getResponseCode()
            var bmp:Bitmap? = null
            if(res == HttpURLConnection.HTTP_OK){
                val inps = connector.getInputStream() as InputStream
                bmp = BitmapFactory.decodeStream(inps)
                inps.close()
            }
            return bmp
        }catch(e: Exception){
            Log.e("error","error",e)
            return null
        }
    }
}