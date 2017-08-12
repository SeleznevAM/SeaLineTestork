package com.applications.whazzup.sealinetestwork.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.applications.whazzup.sealinetestwork.R
import com.applications.whazzup.sealinetestwork.ui.adapter.adapterModel.Item

class TypeAdapter(private val listener : ((Item)->Unit)) : RecyclerView.Adapter<TypeAdapter.ViewHolder>(){

    private var itemList : MutableList<Item> = mutableListOf()

    fun addItem(item : Item){
        itemList.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var i = itemList[position]
        holder?.objText?.text = i.getInfoFromObject()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent?.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_item, parent, false), listener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class ViewHolder(itemView : View, var listener : (Item) ->Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        override fun onClick(v: View?) {
            listener.invoke(itemList[adapterPosition])
        }

        var objText : TextView = itemView.findViewById(R.id.obj_info_tv) as TextView

        init{
            objText.setOnClickListener(this)
        }
    }
}