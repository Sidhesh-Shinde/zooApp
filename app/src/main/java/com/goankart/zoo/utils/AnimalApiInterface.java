package com.goankart.zoo.utils;


import com.goankart.zoo.models.Animal;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by user on 16/11/2015.
 */
public interface AnimalApiInterface {
    @GET("/SiD.json")
    void getStreams(Callback<List<Animal>> callback);
}
