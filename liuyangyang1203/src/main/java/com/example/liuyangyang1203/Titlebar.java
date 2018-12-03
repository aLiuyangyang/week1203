package com.example.liuyangyang1203;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Titlebar extends LinearLayout {
    private EditText edit;
    private ImageView imageView;
    private Context context;
    public Titlebar(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public Titlebar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init() {
        View view=View.inflate(context,R.layout.title,null);
        edit=view.findViewById(R.id.edit);
        imageView=view.findViewById(R.id.image);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monbut!=null){
                    monbut.setsuccess(edit.getText().toString());
                }
            }
        });
        addView(view);
    }

    OnBut monbut;

    public void setBut(OnBut onBut){
        monbut=onBut;
    }


    public interface OnBut{
        void setsuccess(String str);
    }
}
