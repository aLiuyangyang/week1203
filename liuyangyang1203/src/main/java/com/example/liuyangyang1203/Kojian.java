package com.example.liuyangyang1203;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import org.w3c.dom.Text;

@SuppressLint("AppCompatCustomView")
public class Kojian extends TextView {
    public Kojian(Context context) {
        super(context);
    }

    public Kojian(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Kojian);
        int color = typedArray.getColor(R.styleable.Kojian_TextColor, Color.RED);
        setTextColor(color);
        //回收
        typedArray.recycle();

    }
}
