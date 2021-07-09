package com.example.customviewgroup

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.core.widget.NestedScrollView
import android.view.MotionEvent




class CustomScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : NestedScrollView(context, attrs) {
    private var scrollable = true
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return scrollable && super.onInterceptTouchEvent(ev)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
    }
    override fun onOverScrolled(scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean) {

//        if (getScrollY())
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY)
    }
    fun setScrollingEnabled(enabled: Boolean) {
        scrollable = enabled
    }
}