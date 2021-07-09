package com.example.customviewgroup.adapter

import androidx.recyclerview.widget.DiffUtil

class ControlDiffUtilCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }


}
