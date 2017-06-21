package com.practice.sho_ma.practice_application

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

// add librarys here
import android.widget.*
import org.json.JSONObject
import java.util.ArrayList

class MainActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById(R.id.textView) as TextView
        val button1 = findViewById(R.id.button1) as Button
        val button2 = findViewById(R.id.button2) as Button

        val testString = "{\"screen_name\":\"katty0324\",\"age\":23}";
        val testArray = ArrayList<Int>() as ArrayList<Int>
        var i = 0
        while(i < 100){
            testArray.add(i)
            i = i + 1
        }
        val listAdapter = ArrayAdapter(this, R.layout.list_content, testArray)

        button1.setOnClickListener{
            v ->
            textView1.text = "hogehoge"
            makeToast("hogehoge")
            try{
                var jsonobject = JSONObject(testString) as JSONObject
                makeToast("json test :" + jsonobject.getString("screen_name"))
            }catch(e: Exception){
                makeToast("miss")
            }
        }

        button2.setOnClickListener{
            v ->
            setContentView(R.layout.list_activity)
            val listview1 = findViewById(R.id.listView1) as ListView
            listview1.setAdapter(listAdapter)
        }
    }

    fun makeToast(massage: String){
        val toast = Toast.makeText(this, massage, Toast.LENGTH_SHORT)
        toast.show()
    }
}
