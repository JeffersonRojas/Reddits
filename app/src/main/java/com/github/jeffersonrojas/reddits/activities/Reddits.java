package com.github.jeffersonrojas.reddits.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.github.jeffersonrojas.reddits.R;
import com.github.jeffersonrojas.reddits.adapters.RedditsAdapter;
import com.github.jeffersonrojas.reddits.holders.RedditHolder;
import com.github.jeffersonrojas.reddits.models.RedditsResponse;
import com.github.jeffersonrojas.reddits.requests.ApiClient;
import com.github.jeffersonrojas.reddits.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class Reddits extends AppCompatActivity {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rv_reddits)
    RecyclerView rvReddits;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    ApiClient apiClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddits);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        apiClient = new ApiClient(this);
        swipeRefreshLayout.setOnRefreshListener(this::onRefresh);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        rvReddits.setLayoutManager(new LinearLayoutManager(this));
        onRefresh();
    }

    public void onRefresh() {
        apiClient.getReddits().subscribe(this::onRedditsResponse, this::onRedditsError);
    }

    public void onRedditsResponse(RedditsResponse redditsResponse) {
        swipeRefreshLayout.setRefreshing(false);
        rvReddits.setAdapter(new RedditsAdapter(redditsResponse));
        DataUtils.save(this, redditsResponse);
    }

    public void onRedditsError(@SuppressWarnings("unused") Throwable throwable) {
        swipeRefreshLayout.setRefreshing(false);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, getString(R.string.offline_indicator), Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getString(R.string.connect), view -> {
            swipeRefreshLayout.setRefreshing(true);
            onRefresh();
        });
        snackbar.show();
        RedditsResponse redditsResponse = DataUtils.load(this, RedditsResponse.class);
        if (redditsResponse != null) {
            rvReddits.setAdapter(new RedditsAdapter(redditsResponse));
        }
    }

    public void onRedditSelected(RedditHolder redditHolder) {
        Intent intent = new Intent(this, RedditDetail.class);
        DataUtils.putExtra(intent, redditHolder.binding.getRedditModel());
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, redditHolder.ivIcon, getString(R.string.shared_element_icono));
        startActivity(intent, options.toBundle());
    }

}
