package com.example.liuyangyang1203;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private Titlebar titlebar;
    private Button button;
    private Dao dao;
    private MyWaterFall myWaterFall,myWaterFall1;
    private Kojian kojian1,kojian2;
    private String[] name=new String[]{"豆豆鞋","牙刷","牙膏","连衣裙","裤子"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       inif();
    }

    private void inif() {
        titlebar=findViewById(R.id.title);
        myWaterFall=findViewById(R.id.myview);
        dao=new Dao(MainActivity.this);
        button=findViewById(R.id.butt);
        myWaterFall1=findViewById(R.id.myview1);
        List<Bean> select = dao.select();
        for (int i = 0; i < select.size(); i++) {
            TextView textView3=new TextView(MainActivity.this);
            String name = select.get(i).getName();
            textView3.setTextColor(Color.BLACK);
            textView3.setBackgroundResource(R.drawable.ed);
            textView3.setText(name);
            myWaterFall.addView(textView3);
        }
        titlebar.setBut(new Titlebar.OnBut() {
            @Override
            public void setsuccess(String str) {
                UUID uuid = UUID.randomUUID();
                TextView textView1=new TextView(MainActivity.this);
                textView1.setText(str);
                textView1.setTag(uuid);
                textView1.setTextColor(Color.BLACK);
                textView1.setBackgroundResource(R.drawable.ed);
                dao.add(str,uuid.toString());
                myWaterFall.addView(textView1);
            }
        });

        for (int i = 0; i < name.length; i++) {
            TextView textView2=new TextView(MainActivity.this);
            textView2.setText(name[i]);
            textView2.setTextColor(Color.BLACK);
            textView2.setBackgroundResource(R.drawable.ed);
            myWaterFall1.addView(textView2);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete();
                myWaterFall.removeAllViews();
            }
        });
    }
}
