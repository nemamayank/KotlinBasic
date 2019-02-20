package com.mayank.kotlinbasic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_row.view.*

/**
 *  Recycler View holding list of items linked to [RecyclerViewList]
 */
class RecyclerListAdapter(var context: Context, var lists: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        /**
         *  Attaching layout to ViewHolder
         */
        val v = LayoutInflater.from(context).inflate(R.layout.list_item_row, viewGroup, false)
        return Item(v)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as Item).bindData(lists[position])
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(_list: String) {
            itemView.textTitle.text = _list
        }
    }
}