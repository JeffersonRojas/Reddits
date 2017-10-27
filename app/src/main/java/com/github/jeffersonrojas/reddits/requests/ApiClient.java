package com.github.jeffersonrojas.reddits.requests;

import android.content.Context;

import com.github.jeffersonrojas.reddits.R;
import com.github.jeffersonrojas.reddits.models.RedditsResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class ApiClient {

    private ApiInterface apiInterface;

    public ApiClient(Context context) {
        apiInterface = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(context.getString(R.string.base_url))
                .build()
                .create(ApiInterface.class);
    }

    public Observable<RedditsResponse> getReddits() {
        return apiInterface.getReddits().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
