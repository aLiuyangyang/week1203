package com.example.liuyangyang1203;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Dao{
    private MySqilte mySqilte;
    private SQLiteDatabase database;
    public Dao(Context context){
        mySqilte=new MySqilte(context);
        database=mySqilte.getReadableDatabase();
    }
    public void add(String name,String uuid){
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("uuid",uuid);
        database.insert("user",null,values);
    }
    public List<Bean> select(){
        List<Bean> list=new ArrayList<>();

        Cursor query = database.query("user", null, null, null, null, null, null);
        while (query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            String uuid = query.getString(query.getColumnIndex("uuid"));
            Bean bean=new Bean(name,uuid);
            list.add(bean);
        }
        return list;
    }
    public void delete(){
        database.delete("user",null,null);
    }
}
