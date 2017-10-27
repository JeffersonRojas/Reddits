package com.github.jeffersonrojas.reddits.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.jeffersonrojas.reddits.R;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, Reddits.class);
            startActivity(intent);
            finish();
        }, getResources().getInteger(R.integer.delay_splash));
    }

}
