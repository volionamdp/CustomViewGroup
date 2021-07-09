package com.example.customviewgroup

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue.COMPLEX_UNIT_DIP

import android.util.TypedValue

import android.view.MotionEvent
import android.view.View

import androidx.core.view.MotionEventCompat

import androidx.core.widget.NestedScrollView


class HorizontalFavoringNestedScrollView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : NestedScrollView(context, attrs) {
    private var mLastMotionY = 0
    private var mTouchSlop = 0
    private var mActivePointerId = -1

    init {
        mTouchSlop = TypedValue.applyDimension(COMPLEX_UNIT_DIP, 40f, resources.displayMetrics)
            .toInt()
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        // Gives extra preference to horizontal scrolling
        when (MotionEventCompat.getActionMasked(ev)) {
            MotionEvent.ACTION_MOVE -> {
                val activePointerId = mActivePointerId
                if (activePointerId == INVALID_POINTER) {
                    // If we don't have a valid id, the touch down wasn't on content.
                    return super.onInterceptTouchEvent(ev)
                }
                val pointerIndex = MotionEventCompat.findPointerIndex(ev, activePointerId)
                if (pointerIndex == -1) {
                    return super.onInterceptTouchEvent(ev)
                }
                val x = MotionEventCompat.getX(ev, pointerIndex).toInt()
                val y = MotionEventCompat.getY(ev, pointerIndex).toInt()
                val yDiff = Math.abs(y - mLastMotionY)
                if (yDiff < mTouchSlop) {
                    return false
                }
            }
            MotionEvent.ACTION_DOWN -> {
                val y = ev.y.toInt()
                if (!inChild(ev.x.toInt(), y)) {
                    return super.onInterceptTouchEvent(ev)
                }

                /*
                 * Remember location of down touch.
                 * ACTION_DOWN always refers to pointer index 0.
                 */mLastMotionY = y
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0)
            }
            MotionEvent.ACTION_UP -> {

                /* Release the drag */mActivePointerId = INVALID_POINTER
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    private fun inChild(x: Int, y: Int): Boolean {
        if (childCount > 0) {
            val scrollY = scrollY
            val child: View = getChildAt(0)
            return !(y < child.top - scrollY || y >= child.bottom - scrollY || x < child.left || x >= child.right)
        }
        return false
    }

    companion object {
        private const val INVALID_POINTER = -1
    }
}