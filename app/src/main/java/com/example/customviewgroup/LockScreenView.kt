package com.example.customviewgroup

import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.drawable.VectorDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewgroup.ViewEx.disableScrollRecyclerView
import com.example.customviewgroup.ViewEx.enableScrollRecyclerView
import kotlin.math.abs


class LockScreenView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var lockDrawable1: VectorDrawable? = null
    private var lockDrawable2: VectorDrawable? = null
    private var lockView1: ImageView? = null
    private var lockView2: ImageView? = null
    private var lockOn: Boolean = false
    private var path: Path? = null
    private var clickListener: (isShow: Boolean) -> Unit = {
        Log.d("cliii", ": vvv")
    }

    init {
        var imageView = ImageView(context)
        imageView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        addView(imageView)
        imageView.setImageResource(R.drawable.lock_1)
        lockView1 = imageView

        imageView = ImageView(context)
        imageView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        addView(imageView)
        imageView.setImageResource(R.drawable.lock_2)
        lockView2 = imageView
    }

    fun setListener(listener: (isShow: Boolean) -> Unit) {
        clickListener = listener
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        path = RoundedRect(0f, 0f, width.toFloat(), height.toFloat(), 50f, 50f, false)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }

    fun RoundedRect(
        left: Float,
        top: Float,
        right: Float,
        bottom: Float,
        rx: Float,
        ry: Float,
        conformToOriginalPost: Boolean
    ): Path {
        var rx = rx
        var ry = ry
        val path = Path()
        if (rx < 0) rx = 0f
        if (ry < 0) ry = 0f
        val width = right - left
        val height = bottom - top
        if (rx > width / 2) rx = width / 2
        if (ry > height / 2) ry = height / 2
        val widthMinusCorners = width - 2 * rx
        val heightMinusCorners = height - 2 * ry
        path.moveTo(right, top + ry)
        path.rQuadTo(0f, -ry, -rx, -ry) //top-right corner
        path.rLineTo(-widthMinusCorners, 0f)
        path.rQuadTo(-rx, 0f, -rx, ry) //top-left corner
        path.rLineTo(0f, heightMinusCorners)
        if (conformToOriginalPost) {
            path.rLineTo(0f, ry)
            path.rLineTo(width, 0f)
            path.rLineTo(0f, -ry)
        } else {
            path.rQuadTo(0f, ry, rx, ry) //bottom-left corner
            path.rLineTo(widthMinusCorners, 0f)
            path.rQuadTo(rx, 0f, rx, -ry) //bottom-right corner
        }
        path.rLineTo(0f, -heightMinusCorners)
        path.close() //Given close, last lineto can be removed.
        return path
    }

    override fun dispatchDraw(canvas: Canvas?) {
        canvas?.save()
        path?.let { canvas?.clipPath(it) }
        canvas?.drawColor(Color.RED)
        super.dispatchDraw(canvas)
        canvas?.restore()
    }

    var check: Boolean = true
    private var downX = 0f
    private var downY = 0f
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                disableScrollRecyclerView()
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
                if (check) {
                    animView()
                } else {
                    hideGroup(downX, downY, ev.x, ev.y)
                }
                enableScrollRecyclerView()
            }
        }

        return true
    }

    private fun hideGroup(downX: Float, downY: Float, upX: Float, upY: Float) {
        var group = parent
        while (group != null) {
            try {
                Log.d("ggg", "onTouchEvent: ${group::class.java.name}")
                if (group is CustomViewGroup) {
                    group.animUp(downX, downY, upX, upY)
                    break
                }
                group = group.parent
            } catch (e: Exception) {
                Log.d("ggg", "hideGroup: ${e.message}")
                break
            }
        }
    }

    private fun animView() {
        if (lockOn) {
            animViewHide()
        } else {
            animView2()
        }
        Log.d("cliii", "animView: ")
        clickListener(lockOn)
        lockOn = !lockOn
    }

    private fun animView2() {
        ValueAnimator.ofFloat(-360f, 0f).apply {
            duration = 1000
//            interpolator = DecelerateInterpolator()
            interpolator = TimeInterpolator { input ->
                Log.d(
                    "zzzz",
                    "animView2: $input  ${(1.0f - (1.0f - input) * (1.0f - input) * (1.0f - input))}"
                )
                (1.0f - (1.0f - input) * (1.0f - input) * (1.0f - input))
            }
            addUpdateListener {
                lockView1?.rotation = it.animatedValue as Float
            }
            start()
        }

        lockView2?.rotation = -20f
        val anim = SpringAnimation(
            lockView2, DynamicAnimation.ROTATION, 0f
        )
        anim.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        anim.spring.stiffness = SpringForce.STIFFNESS_LOW
        anim.start()

    }

    private fun animViewHide() {
        lockView1?.rotation = -20f
        var anim = SpringAnimation(
            lockView1, DynamicAnimation.ROTATION, 0f
        )
        anim.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        anim.spring.stiffness = SpringForce.STIFFNESS_LOW
        anim.start()

        lockView2?.rotation = -20f
        anim = SpringAnimation(
            lockView2, DynamicAnimation.ROTATION, 0f
        )
        anim.spring.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        anim.spring.stiffness = SpringForce.STIFFNESS_LOW
        anim.start()

    }
}