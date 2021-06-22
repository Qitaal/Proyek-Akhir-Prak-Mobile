package com.upnyk.tenorapp.service;

import com.upnyk.tenorapp.service.model.DetailResponse;
import com.upnyk.tenorapp.service.model.SearchResponse;
import com.upnyk.tenorapp.service.model.TrendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TenorAPI {

    @GET("trending?key=3S7OQ8A77YQ4&limit=50")
    Call<TrendingResponse> getTrending();

    @GET("search?key=3S7OQ8A77YQ4&limit=50")
    Call<SearchResponse> getSearch(@Query("q") String q);

    @GET("gifs")
    Call<DetailResponse> getDetail(
            @Query("ids") String ids,
            @Query("key") String key
    );
}
