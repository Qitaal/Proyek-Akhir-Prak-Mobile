package com.upnyk.tenorapp.service;

import com.upnyk.tenorapp.service.model.TrendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TenorAPI {

    @GET("trending?key=3S7OQ8A77YQ4&limit=50")
    Call<TrendingResponse> getTrending();
}
