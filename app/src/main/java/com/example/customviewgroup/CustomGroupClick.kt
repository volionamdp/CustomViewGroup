package com.example.customviewgroup

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.abs

class CustomGroupClick @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var check: Boolean = true
    private var downX = 0f
    private var downY = 0f
    private val vc: ViewConfiguration = ViewConfiguration.get(context)
    private val mSlop: Int = vc.scaledTouchSlop
    private val mMinFlingVelocity: Int = vc.scaledMinimumFlingVelocity
    private val mMaxFlingVelocity: Int = vc.scaledMaximumFlingVelocity
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                check = true
                downX = ev.x
                downY = ev.y
            }
            MotionEvent.ACTION_MOVE -> {
                if (abs(ev.x - downX) > 30 || abs(ev.y - downY) > 30) {
                    check = false
                }

            }
            MotionEvent.ACTION_UP -> {
                if (check){
                    Log.d(TAG, "onTouchEvent: click")
                }else{
                    val group = parent
                    if (group is CustomViewGroup){
                        group.animUp(downX, downY, ev.x, ev.y)
                    }
                }
            }
        }

        return true
    }


    companion object {
        private const val TAG = "CustomViewGroup"
    }
}