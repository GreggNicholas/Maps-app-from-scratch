package com.example.mapsfromscratch.Network;

import com.example.mapsfromscratch.Model.MuseumList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumService {

    @GET("/JDVila/storybook/master/museums.json")
    Call<MuseumList> getMuseumObject();


}

