package com.github.jeffersonrojas.reddits.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
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
            @SuppressWarnings("ConfusingArgumentToVarargsMethod")
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,null);
            startActivity(intent, options.toBundle());
            finish();
        }, getResources().getInteger(R.integer.delay_splash));
    }

}
