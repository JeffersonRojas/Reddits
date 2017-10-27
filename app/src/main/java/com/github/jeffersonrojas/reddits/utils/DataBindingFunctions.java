package com.github.jeffersonrojas.reddits.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jeffersonrojas.reddits.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import ru.noties.markwon.Markwon;

/**
 * Created by Jefferson Rojas on 26/10/17.
 */

public class DataBindingFunctions {

    @BindingAdapter("loadIcon")
    public static void loadIcon(ImageView imageView, String imageUrl) {
        Context context = imageView.getContext();
        RequestCreator requestCreator;
        if (imageUrl == null || imageUrl.isEmpty()) {
            requestCreator = Picasso.with(context).load(R.drawable.ic_default_reddit);
        } else {
            requestCreator = Picasso.with(context).load(imageUrl);
        }
        requestCreator.transform(new CircleTransform())
                .error(R.drawable.ic_default_reddit)
                .placeholder(R.drawable.ic_default_reddit)
                .into(imageView);
    }

    @BindingAdapter("loadBanner")
    public static void loadBanner(ImageView imageView, String bannerUrl) {
        if (bannerUrl == null || bannerUrl.isEmpty()) return;
        Context context = imageView.getContext();
        Picasso.with(context).load(bannerUrl).into(imageView);
    }

    @BindingAdapter("loadMD")
    public static void loadMD(TextView textView, String mdText) {
        Markwon.setMarkdown(textView, mdText);
    }

}
