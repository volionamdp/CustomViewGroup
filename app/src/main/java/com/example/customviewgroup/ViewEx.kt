package com.example.customviewgroup

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

object ViewEx {
    fun View.disableScrollRecyclerView(){
        var group = parent
        while (group != null) {
            try {
                if (group is RecyclerView) {
                    group.requestDisallowInterceptTouchEvent(true)
                    break
                }
                group = group.parent
            } catch (e: Exception) {
                break
            }
        }
    }
    fun View.enableScrollRecyclerView(){
        var group = parent
        while (group != null) {
            try {
                if (group is RecyclerView) {
                    group.requestDisallowInterceptTouchEvent(false)
                    break
                }
                group = group.parent
            } catch (e: Exception) {
                break
            }
        }
    }
}