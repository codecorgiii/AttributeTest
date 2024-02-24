package com.codecorgiii.substance;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;

import androidx.annotation.InspectableProperty;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.resourceinspection.annotation.Attribute;


public class SubstanceTestView extends View {
    private static final int DEFAULT_HUE = 0;
    private int mHue;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public SubstanceTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SubstanceTestView);
        mHue = a.getInteger(R.styleable.SubstanceTestView_substance_hue, DEFAULT_HUE) % 360;
        a.close();

        mPaint.setColor(ColorUtils.HSLToColor(new float[]{ mHue, 0.5F, 0.5F }));
    }

    @Attribute("com.codecorgiii.substance:substance_hue")
    public int getHue() {
        return mHue;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawRect(0F, 0F, getWidth(), getHeight(), mPaint);
    }
}