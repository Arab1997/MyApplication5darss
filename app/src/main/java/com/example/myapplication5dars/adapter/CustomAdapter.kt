package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.model.Member
import com.example.myapplication5dars.R

class CustomAdapter(val context: Context, val members: List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() { //Paging  add method val listener: OnBottomReachedListener

    //---------------------Position belgalab ovomiza ---------------------//
     companion object {
         private val TYPE_ITEM_VIEW = 0    //type
         private val TYPE_ITEM_LIST = 1    //type
     }
    override fun getItemCount(): Int {
        return members.size
    }
    // -------------------- Hohlagan turdagi listni hosil qiladi-------------------------//

    override fun getItemViewType(position: Int): Int {
//--------------------5 dars RecyclerView ichida RecyclerView ishlatish--------------------------//
        return if (members[position].memberSubs.size >0) TYPE_ITEM_LIST else TYPE_ITEM_VIEW   // typeni belgilab olamiza

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

         if (viewType == TYPE_ITEM_LIST) {
             val header = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_list, parent, false)
             return CustomListHolder(header)
         }

         val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_view, parent, false)
         return CustomViewHolder(footer)

     }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)
       if (holder is CustomViewHolder){

       }

        if (holder is CustomListHolder) {
          val recyclerView = holder.recyclerView
            recyclerView.layoutManager = GridLayoutManager(context, 1) //bittalik element

            val memberSubs = member.memberSubs //  recyclerView ichidagi Submemberlar
           refreshSubAdapter(recyclerView, memberSubs)
        }

    }
    private fun refreshSubAdapter(recyclerView: RecyclerView, memberSubs: List<Member>){
        val adapter =CustomSubAdapter(context, memberSubs)
        recyclerView.adapter = adapter
    }
    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    class CustomListHolder(view: View):RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
        }

    }


}


