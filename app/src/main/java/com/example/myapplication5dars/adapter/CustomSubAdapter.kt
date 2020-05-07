package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Member

import com.example.myapplication5dars.R

class CustomSubAdapter(private val context: Context, private val memberSubs: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() { //Paging  add method val listener: OnBottomReachedListener

    override fun getItemCount(): Int {
        return memberSubs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_view_sub, false)
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_view_sub,parent,false)
        return CustomSubViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val (status) = memberSubs[position]
    }

    class CustomSubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}







