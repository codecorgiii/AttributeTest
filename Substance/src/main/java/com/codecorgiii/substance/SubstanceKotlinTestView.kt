package com.codecorgiii.substance

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.ColorUtils
import androidx.resourceinspection.annotation.Attribute


class SubstanceKotlinTestView(context: Context, attrs: AttributeSet?) :
    View(context, attrs) {
    @get:Attribute("com.codecorgiii.substance:substance_kotlin_hue")
    var hue: Int
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.SubstanceKotlinTestView)
        hue = a.getInteger(R.styleable.SubstanceKotlinTestView_substance_kotlin_hue, DEFAULT_HUE) % 360
        a.close()
        mPaint.color = ColorUtils.HSLToColor(floatArrayOf(hue.toFloat(), 0.5f, 0.5f))
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
    }

    companion object {
        private const val DEFAULT_HUE = 0
    }
}