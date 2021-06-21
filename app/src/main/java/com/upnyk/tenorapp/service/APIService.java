package com.upnyk.tenorapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private Retrofit retrofit = null;
    public String BASE_URL = "https://g.tenor.com/v1/";

    public TenorAPI getAPI(){
        if (retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TenorAPI.class);
    }
}
