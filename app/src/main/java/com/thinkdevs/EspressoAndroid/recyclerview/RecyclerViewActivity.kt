package com.thinkdevs.EspressoAndroid.recyclerview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.thinkdevs.EspressoAndroid.adapter.NumberedAdapter
import com.thinkdevs.EspressoAndroid.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setTitle(R.string.title)
        val footer = findViewById<TextView>(R.id.footer)
        footer.setBackgroundColor(Color.LTGRAY)
        footer.visibility = View.GONE

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = NumberedAdapter(
            30,
            object : NumberedAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    footer.text = position.toString()
                    footer.visibility = View.VISIBLE
                }
            })
    }
}
