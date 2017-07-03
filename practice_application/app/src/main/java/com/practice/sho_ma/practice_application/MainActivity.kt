package com.practice.sho_ma.practice_application

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

//add library
import android.widget.*
//these are used by swipe action
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import com.practice.sho_ma.practice_application.MyPagerAdapter

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.setAdapter(MyPagerAdapter(getSupportFragmentManager()))
    }
    fun makeToast(massage: String){
        val toast = Toast.makeText(this, massage, Toast.LENGTH_SHORT)
        toast.show()
    }
}