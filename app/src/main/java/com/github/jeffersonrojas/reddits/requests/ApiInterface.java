package com.github.jeffersonrojas.reddits.requests;

import com.github.jeffersonrojas.reddits.models.RedditsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public interface ApiInterface {

    @GET("reddits.json")
    Observable<RedditsResponse> getReddits();

}
