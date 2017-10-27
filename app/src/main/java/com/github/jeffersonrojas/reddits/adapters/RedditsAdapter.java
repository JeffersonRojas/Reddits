package com.github.jeffersonrojas.reddits.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.jeffersonrojas.reddits.holders.RedditHolder;
import com.github.jeffersonrojas.reddits.models.RedditModel;
import com.github.jeffersonrojas.reddits.models.RedditsResponse;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class RedditsAdapter extends RecyclerView.Adapter<RedditHolder> {

    private RedditsResponse redditsResponse;

    public RedditsAdapter(RedditsResponse redditsResponse) {
        this.redditsResponse = redditsResponse;
    }

    @Override
    public RedditHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RedditHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RedditHolder holder, int position) {
        RedditModel redditModel = redditsResponse.listing.children.get(position).redditModel;
        holder.binding.setRedditModel(redditModel);
    }

    @Override
    public int getItemCount() {
        return redditsResponse.listing.children.size();
    }

}
