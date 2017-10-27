package com.github.jeffersonrojas.reddits.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class RedditsResponse {

    @SerializedName("kind")
    public String kind;

    @SerializedName("data")
    public Listing listing;

}
