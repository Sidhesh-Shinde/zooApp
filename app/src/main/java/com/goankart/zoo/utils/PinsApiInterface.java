package com.goankart.zoo.utils;

import com.goankart.zoo.models.Pin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by user on 19/11/2015.
 */
public interface PinsApiInterface {
    @GET("/pins.json")
    void getStreams(Callback<List<Pin>> callback);
}
