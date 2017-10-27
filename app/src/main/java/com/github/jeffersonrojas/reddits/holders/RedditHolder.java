package com.github.jeffersonrojas.reddits.holders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.jeffersonrojas.reddits.R;
import com.github.jeffersonrojas.reddits.activities.Reddits;
import com.github.jeffersonrojas.reddits.databinding.HolderRedditBinding;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class RedditHolder extends RecyclerView.ViewHolder {

    public static RedditHolder create(ViewGroup parent) {
        if (parent == null) return null;
        View viewHolder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_reddit, parent, false);
        return new RedditHolder(viewHolder);
    }

    public HolderRedditBinding binding;

    @BindView(R.id.iv_icon)
    public ImageView ivIcon;

    private RedditHolder(View viewHolder) {
        super(viewHolder);
        binding = HolderRedditBinding.bind(viewHolder);
        ButterKnife.bind(this, viewHolder);
    }

    @OnClick(R.id.parent_holder)
    void hola() {
        Reddits reddits = (Reddits) binding.getRoot().getContext();
        reddits.onRedditSelected(this);
    }

}
