package com.example.customviewgroup.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewgroup.LockScreenView
import com.example.customviewgroup.R

class ControlAdapter(
    val onClick: (item: String,position:Int) -> Unit,
) : ListAdapter<Any, RecyclerView.ViewHolder>(ControlDiffUtilCallback()) {
    private var currentItemPosition:Int = 0
    private var itemHeight = 40
    var listener:(view:View)->Unit = {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_test, parent, false)

        return ItemChildren(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemChildren -> {
                if (currentList[position] is String){
                    holder.bind(false)
                }
            }
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (payloads.any { it is InfoMessageChanged }) {
                (holder as ItemChildren).bind(true)
            }
        }
    }

    inner class ItemChildren(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(isUpdate: Boolean) {
            val position = layoutPosition
            val item = currentList[position]

            itemView.findViewById<LockScreenView>(R.id.lock).setListener {
                listener(itemView.findViewById(R.id.trans))

            }

        }
    }
    public fun setScreenWidth(width:Int){
        itemHeight = width/9
    }

    fun setSelectPosition(position: Int) {
        val oldSPosition = currentItemPosition
        currentItemPosition = position
        notifyItemChanged(currentItemPosition)
        notifyItemChanged(oldSPosition)
    }

    class InfoMessageChanged

}