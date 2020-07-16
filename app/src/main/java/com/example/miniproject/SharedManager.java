package com.example.miniproject;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedManager {
    private static SharedManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME="mySharedpref";
    private static final String KEY_USERNAME="UserName";
    private static final String KEY_USER_ID="LoginID";

    private SharedManager(Context context){
        mCtx=context;
    }

    public static synchronized SharedManager getInstance(Context context){
        if (mInstance==null){
            mInstance=new SharedManager(context);
        }
        return mInstance;
    }
    public boolean userLogin(int id, String UserName){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USERNAME, UserName);
        editor.apply();

        return true;
    }

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USERNAME,null)!=null){
            return true;
        }
        return false;
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}
