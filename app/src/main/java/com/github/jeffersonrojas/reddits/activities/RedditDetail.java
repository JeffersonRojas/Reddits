package com.github.jeffersonrojas.reddits.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.jeffersonrojas.reddits.R;
import com.github.jeffersonrojas.reddits.databinding.ActivityRedditDetailBinding;
import com.github.jeffersonrojas.reddits.models.RedditModel;
import com.github.jeffersonrojas.reddits.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class RedditDetail extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    ActivityRedditDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reddit_detail);
        binding.setRedditModel(DataUtils.getExtra(getIntent(), RedditModel.class));
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            int maxScroll = appBarLayout.getTotalScrollRange();
            float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
            toolbar.setAlpha(percentage);
        });
        setTitle(binding.getRedditModel().title);
    }

}
