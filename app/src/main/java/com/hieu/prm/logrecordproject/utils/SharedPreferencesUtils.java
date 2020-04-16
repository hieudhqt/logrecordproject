package com.hieu.prm.logrecordproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SharedPreferencesUtils {

    private static final String TAG = "SharedPreferencesUtils";

    public static final String ACCESS_TOKEN = "com.hieu.prm.ACCESS_TOKEN";
    public static final String EMAIL = "com.hieu.prm.EMAIL";
    public static final String IS_LOGIN = "com.hieu.prm.IS_LOGIN";

    public static void saveString(Context context, String key, String value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        String defValue = "This shared preference is null";
        return preferences.getString(key, defValue);
    }

    public static void saveBoolean(Context context, String key, boolean value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    public static void removeKey(Context context, String key) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            Editor editor = preferences.edit();
            editor.remove(key);
            editor.commit();
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
    }

}
