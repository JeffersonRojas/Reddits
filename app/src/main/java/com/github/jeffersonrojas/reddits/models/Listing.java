package com.github.jeffersonrojas.reddits.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class Listing {

    @SerializedName("modhash")
    public String modhash;

    @SerializedName("whitelist_status")
    public String whitelistStatus;

    @SerializedName("children")
    public List<Children> children;

    @SerializedName("after")
    public String after;

    @SerializedName("before")
    public String before;

}
