package com.github.jeffersonrojas.reddits.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class DataUtils {

    public static void putExtra(Intent intent, Object object) {
        intent.putExtra(object.getClass().getName(), new Gson().toJson(object));
    }

    public static <T> T getExtra(Intent intent, Class<T> classOfT) {
        String json = intent.getStringExtra(classOfT.getName());
        return new Gson().fromJson(json, classOfT);
    }

    public static void save(Context context, Object object) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(object.getClass().getName(), new Gson().toJson(object));
        editor.apply();
    }

    public static <T> T load(Context context, Class<T> classOfT) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(classOfT.getName(), "");
        return new Gson().fromJson(json, classOfT);
    }

}
