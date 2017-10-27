package com.github.jeffersonrojas.reddits.utils;

import android.content.Intent;

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

}
