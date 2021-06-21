package com.upnyk.tenorapp.view.search;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.tenorapp.service.APIService;
import com.upnyk.tenorapp.service.model.ResultsItem;
import com.upnyk.tenorapp.service.model.SearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

    private static final String TAG = "SearchViewModel";
    private MutableLiveData<List<ResultsItem>> gifList;

    public SearchViewModel() {
        gifList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ResultsItem>> getGifList() {
        return gifList;
    }

    public void searchGif(String key){
        APIService apiService = new APIService();
        apiService.getAPI().getSearch(key).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                gifList.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                gifList.setValue(null);
                Log.d(TAG, "onFailure: SEARCH API FAIL....");
            }
        });
    }
}
