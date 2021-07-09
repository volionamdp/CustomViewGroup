package com.example.customviewgroup

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.children
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce.*
import kotlin.math.abs
import kotlin.math.roundToInt


class CustomViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var paint = Paint()
    private var rectTouch = RectF()
    private var rectDraw = RectF()
    private var rectSize = 300f
    private var rectWidth = 20f
    private var gravityRect: Int = RIGHT
    private var hideTouch: Int = RIGHT
    private var showView = true
    private var duration: Long = 1000
    private var currentAnim: ValueAnimator? = null
    private var listAnime: MutableList<SpringAnimation> = mutableListOf()
    private var animEnd = true
    private var listener:GroupListener? = null
    init {
        paint.color = Color.RED
    }
    fun setListener(groupListener: GroupListener){
        listener = groupListener
    }
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        setGravityRect()
//        setTranslateAllView()
//        setBackgroundAlphaDefault()
    }

    private fun setBackgroundAlphaDefault() {
//        background.alpha = 0
    }

    private fun setTranslateAllView() {
        for (view in children) {
            translateDefaultView(view)
        }
    }
    private fun translateDefaultView(view: View) {
        view.translationY = 0f
        view.translationX = 0f
        when (gravityRect) {
            RIGHT -> {
                view.translationX = width.toFloat()
            }
            LEFT -> {
                view.translationX = -width.toFloat()
            }
            TOP -> {
                view.translationY = -height.toFloat()
            }
            BOTTOM -> {
                view.translationY = height.toFloat()
            }
        }
        view.visibility = View.INVISIBLE
    }

    private fun setGravityRect() {
        when (gravityRect) {
            RIGHT -> {
                val startY = (height - rectSize) / 2f
                rectTouch.set(width - rectWidth * 3, startY, width.toFloat(), startY + rectSize)
                rectDraw.set(width - rectWidth, startY, width.toFloat(), startY + rectSize)
                ViewCompat.setSystemGestureExclusionRects(this, mutableListOf(Rect(rectTouch)))
            }
            LEFT -> {
                val startY = (height - rectSize) / 2f
                rectTouch.set(0f, startY, rectWidth * 3, startY + rectSize)
                rectDraw.set(0f, startY, rectWidth, startY + rectSize)
                ViewCompat.setSystemGestureExclusionRects(this, mutableListOf(Rect(rectTouch)))
            }
            TOP -> {
                val startX = (width - rectSize) / 2f
                rectTouch.set(startX, 0f, startX + rectSize, rectWidth * 3)
                rectDraw.set(startX, 0f, startX + rectSize, rectWidth)
                ViewCompat.setSystemGestureExclusionRects(this, mutableListOf(Rect(rectTouch)))
            }
            BOTTOM -> {
                val startX = (width - rectSize) / 2f
                rectTouch.set(startX, height - rectWidth * 6, startX + rectSize, height.toFloat())
                rectDraw.set(startX, height - rectWidth, startX + rectSize, height.toFloat())
                ViewCompat.setSystemGestureExclusionRects(this, mutableListOf(Rect(rectTouch)))
            }
        }
    }

//    override fun onViewAdded(view: View?) {
//        super.onViewAdded(view)
//        view?.let {
//            translateDefaultView(view)
//        }
//    }

//    override fun dispatchDraw(canvas: Canvas?) {
//        val time = System.nanoTime()
//        canvas?.apply {
//            drawRect(rectDraw, paint)
//        }
//        super.dispatchDraw(canvas)
//        Log.d(TAG, "dispatchDraw: ${System.nanoTime() - time}")
//    }

    private var downX = 0f
    private var downY = 0f
    private var spaceX = 0f
    private var spaceY = 0f
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.rawX
                downY = event.rawY
                downChild(event)
            }
            MotionEvent.ACTION_MOVE -> {
                moveChild(event)
            }
            MotionEvent.ACTION_UP -> {
                animUp(downX, downY, event.rawX, event.rawY)
            }
        }
        return true
    }

    fun animUp(downX: Float, downY: Float, upX: Float, upY: Float) {
        hideTouch = if (abs(upX - downX) - abs(upY - downY) > 0) {
            if (upX - downX > 0) RIGHT else LEFT
        } else {
            if (upY - downY > 0) BOTTOM else TOP
        }
        animUp()
    }

    private fun animUp() {
        if (animEnd) {
            animEnd = false
            if (showView) animHide()
            else animShow()
        }
    }

    private fun animShow() {
        when (gravityRect) {
            RIGHT, LEFT -> {
                animViewShow(true)
            }
            TOP, BOTTOM -> {
                animViewShow(false)
            }
        }
    }

    private fun animHide() {
        when (hideTouch) {
            RIGHT -> {
                animViewHide(width.toFloat(), true)
            }
            LEFT -> {
                animViewHide(-width.toFloat(), true)
            }
            TOP -> {
                animViewHide(-height.toFloat(), false)
            }
            BOTTOM -> {
                animViewHide(height.toFloat(), false)
            }
        }
    }

    private fun animViewHide(end: Float, isX: Boolean = true) {
        for (view in children) {
            val anim = SpringAnimation(
                view, if (isX) {
                    DynamicAnimation.TRANSLATION_X
                } else {
                    DynamicAnimation.TRANSLATION_Y
                }, end
            )
            anim.spring.dampingRatio = DAMPING_RATIO_NO_BOUNCY
            anim.spring.stiffness = if (isX) STIFFNESS_LOW else STIFFNESS_VERY_LOW
            anim.addEndListener { _, _, _, _ ->
                translateDefaultView(view)
                showView = false
                animEnd = true
                listener?.hideAnimEnd()
            }
            anim.addUpdateListener { _, _, _ ->
                setBackgroundAlpha()
            }
            anim.start()
        }

    }

    private fun animViewShow(isX: Boolean = true) {
        for (view in children) {
            val anim = SpringAnimation(
                view, if (isX) {
                    DynamicAnimation.TRANSLATION_X
                } else {
                    DynamicAnimation.TRANSLATION_Y
                }, 0f
            )
            anim.spring.dampingRatio = DAMPING_RATIO_MEDIUM_BOUNCY
            anim.spring.stiffness = if (isX) STIFFNESS_LOW else STIFFNESS_VERY_LOW
            anim.addEndListener { _, _, _, _ ->
                showView = true
                animEnd = true
            }
            anim.addUpdateListener { _, _, _ ->
                setBackgroundAlpha()
            }
            anim.start()
            listAnime.add(anim)
        }
    }

    private var pointDown = PointF()
    private var pointUp = PointF()
    private fun downChild(event: MotionEvent) {
        for (view in children) {
            view.visibility = View.VISIBLE
            pointDown.set(view.translationX, view.translationY)
        }
    }

    private fun moveChild(event: MotionEvent) {
        for (view in children) {
            moveView(view, event)
            pointUp.set(view.translationX, view.translationY)
        }
        setBackgroundAlpha()
    }

    private fun moveView(view: View, event: MotionEvent) {
        when (gravityRect) {
            RIGHT -> {
                view.translationX = pointDown.x.plus(event.rawX - downX)
                if (view.translationX < 0) view.translationX = 0f
                if (view.translationX > width) view.translationX = width.toFloat()
            }
            LEFT -> {
                view.translationX = pointDown.x.plus(event.rawX - downX)
                if (view.translationX > 0) view.translationX = 0f
                if (view.translationX < -width) view.translationX = -width.toFloat()
            }
            TOP -> {
                view.translationY = pointDown.y.plus(event.rawY - downY)
                if (view.translationY > 0) view.translationY = 0f
                if (view.translationY < -height) view.translationY = -height.toFloat()
            }
            BOTTOM -> {
                view.translationY = pointDown.y.plus(event.rawY - downY)
                if (view.translationY < 0) view.translationY = 0f
                if (view.translationY > height) view.translationY = height.toFloat()
            }
        }
    }
    private fun setBackgroundAlpha(){
        getChildAt(0)?.let {
            var alphaBackground = 255 - ((abs(it.translationX/width) + abs(it.translationY/height))*255).roundToInt()
            if (alphaBackground < 5) alphaBackground = 0
            if (alphaBackground  > 200 ) alphaBackground = 255
            background.alpha = alphaBackground
            paint.alpha = 255 - alphaBackground
            postInvalidate()
            listener?.alphaChange(alphaBackground)
        }
    }
    private fun Rect(rectTouch: RectF): Rect {
        return Rect(
            rectTouch.left.toInt(),
            rectTouch.top.toInt(),
            rectTouch.right.toInt(),
            rectTouch.bottom.toInt()
        )
    }
    interface GroupListener{
        fun hideAnimEnd()
        fun alphaChange(value:Int)
    }
    companion object {
        private const val TAG = "CustomViewGroup"
        val RIGHT = 0
        val LEFT = 1
        val BOTTOM = 2
        val TOP = 3
    }
}