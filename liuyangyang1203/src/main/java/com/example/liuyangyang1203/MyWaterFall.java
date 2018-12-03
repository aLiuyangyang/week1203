package com.example.liuyangyang1203;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MyWaterFall extends LinearLayout {
    //最高的孩子
    int mMaxH=20;
    //间距
    int mSpace=20;

    public MyWaterFall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        findMaxH();
        //初始化
        int left=0,top=0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (left!=0){
                if ((left+view.getMeasuredWidth())>w){
                    top+=mMaxH+mSpace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mSpace;
        }
        setMeasuredDimension(w,(top+mMaxH)>h?h:top+mMaxH);
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxH();
        int left=0,top=0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (left!=0){
                if ((left+view.getMeasuredWidth())>getWidth()){
                    top+=mMaxH+mSpace;
                    left=0;
                }
            }
            view.layout(left,top,left+view.getMeasuredWidth(),top+mMaxH);
            left+=view.getMeasuredWidth()+mSpace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void findMaxH() {
           mMaxH=0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mMaxH){
                mMaxH=view.getMeasuredHeight();
            }
        }
    }
}
