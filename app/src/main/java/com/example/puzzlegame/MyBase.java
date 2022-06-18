package com.example.puzzlegame;

import android.content.Context;
import android.content.SharedPreferences;

public class MyBase {
    public static final String SHARED_PREF = "sharedPref";
    public static final String LAST_TIME = "lastTime";
    public static final String LAST_STEP = "lastStep";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    public MyBase(Context context){
        preferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveLastStep(int steps){
        editor.putInt(LAST_STEP, steps).commit();
    }

    public int getLastStep(){
        return preferences.getInt(LAST_STEP, 0);
    }


    public void saveLastTime(int seconds){
        editor.putInt(LAST_TIME, seconds).commit();
    }

    public int getLastTime(){
        return preferences.getInt(LAST_TIME, 0);
    }
}
