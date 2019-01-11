package com.thinkdevs.EspressoAndroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(R.string.title)
    }

    fun greet(v:View){
        greeting.text = getString(R.string.hello)
        greet_button.isEnabled = false
    }
}
