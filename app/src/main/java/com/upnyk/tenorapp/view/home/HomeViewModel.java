package com.upnyk.tenorapp.view.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.tenorapp.service.APIService;
import com.upnyk.tenorapp.service.model.ResultsItem;
import com.upnyk.tenorapp.service.model.TrendingResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";
    private MutableLiveData<List<ResultsItem>> gifList;

    public HomeViewModel() {
        gifList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ResultsItem>> getGifList() {
        return gifList;
    }

    public void loadTrending(){
        APIService apiService = new APIService();
        apiService.getAPI().getTrending().enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {
                gifList.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<TrendingResponse> call, Throwable t) {
                gifList.setValue(null);
                Log.d(TAG, "onFailure: TRENDING API FAIL....");
            }
        });
    }
}
