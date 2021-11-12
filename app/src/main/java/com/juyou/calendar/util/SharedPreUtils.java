package com.juyou.calendar.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.juyou.calendar.base.BaseApplication;


/**
 * desc:
 */
public class SharedPreUtils {
    private static SharedPreUtils sInstance;
    private SharedPreferences sharedReadable;
    private SharedPreferences.Editor sharedWritable;
    private static final String SHARED_NAME = "outerId_pref";
    public static final String OUTER_ID = "outerId";

    public static SharedPreUtils getInstance(){
        if(sInstance == null){
            synchronized (SharedPreUtils.class){
                if (sInstance == null){
                    sInstance = new SharedPreUtils();
                }
            }
        }
        return sInstance;
    }


    private SharedPreUtils(){

        sharedReadable =  BaseApplication.getContext()
                .getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        sharedWritable = sharedReadable.edit();
    }

    public String getString(String key){
        return sharedReadable.getString(key,"");
    }

    public void putString(String key, String value){
        sharedWritable.putString(key,value);
        sharedWritable.commit();
    }

    public void putInt(String key, int value){
        sharedWritable.putInt(key, value);
        sharedWritable.commit();
    }

    public void putBoolean(String key, boolean value){
        sharedWritable.putBoolean(key, value);
        sharedWritable.commit();
    }

    public int getInt(String key, int def){
        return sharedReadable.getInt(key, def);
    }

    public boolean getBoolean(String key, boolean def){
        return sharedReadable.getBoolean(key, def);
    }

}
