package com.thinkdevs.EspressoAndroid.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.thinkdevs.EspressoAndroid.R
import com.thinkdevs.EspressoAndroid.utils.TextViewHolder


class NumberedAdapter(count: Int, private val listener: OnItemClickListener?) : RecyclerView.Adapter<TextViewHolder>() {
  private val labels: MutableList<String>

  init {
    labels = ArrayList(count)
    for (i in 0 until count) {
      labels.add(i.toString())
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(
        R.layout.item, parent, false)
    return TextViewHolder(view)
  }

  override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
    val label = labels[position]
      holder.textView.text = label

    if (listener != null) {
      holder.textView.setOnClickListener {
        listener.onItemClick(position)
      }
    }
  }

  override fun getItemCount(): Int {
    return labels.size
  }

  interface OnItemClickListener {
    fun onItemClick(position: Int)
  }
}