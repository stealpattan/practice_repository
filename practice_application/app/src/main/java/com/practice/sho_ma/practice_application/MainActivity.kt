package com.practice.sho_ma.practice_application

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

// add librarys here
import android.widget.*

class MainActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById(R.id.textView) as TextView
        val button1 = findViewById(R.id.button1) as Button

        button1.setOnClickListener{
            v ->
            textView1.text = "hogehoge"
        }
    }
}
