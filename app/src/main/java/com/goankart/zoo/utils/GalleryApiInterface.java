package com.goankart.zoo.utils;

import com.goankart.zoo.models.GalleryImage;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by user on 17/11/2015.
 */
public interface GalleryApiInterface {
    @GET("/gallery.json")
    void getStreams(Callback<List<GalleryImage>> callback );
}
