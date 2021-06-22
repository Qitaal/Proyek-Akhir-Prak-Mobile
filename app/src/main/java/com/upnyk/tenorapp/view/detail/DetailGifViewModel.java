package com.upnyk.tenorapp.view.detail;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.tenorapp.database.AppDatabase;
import com.upnyk.tenorapp.database.FavoriteGif;
import com.upnyk.tenorapp.service.APIService;
import com.upnyk.tenorapp.service.model.DetailResponse;
import com.upnyk.tenorapp.service.model.ResultsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailGifViewModel extends ViewModel {

    private static final String TAG = "DetailGifViewModel";
    private MutableLiveData<List<ResultsItem>> resultsItem;
    private MutableLiveData<Boolean> isFavorite;

    public DetailGifViewModel() {
        resultsItem = new MutableLiveData<>();
        isFavorite = new MutableLiveData<>();
    }

    public MutableLiveData<List<ResultsItem>> getResultsItem() {
        return resultsItem;
    }

    public MutableLiveData<Boolean> getIsFavorite() {
        return isFavorite;
    }

    public void getDetail(String id){
        APIService apiService = new APIService();
        apiService.getAPI().getDetail(id, "3S7OQ8A77YQ4").enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Log.d(TAG, "onResponse: " + response);
                resultsItem.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                resultsItem.setValue(null);
                Log.d(TAG, "onFailure: DETAIL API FAIL...");
            }
        });
    }

    public void checkIsItFavorite(Context context, String id) {
        new CheckIsItFavoriteAsync(context).execute(id);
    }

    class CheckIsItFavoriteAsync extends AsyncTask<String, Void, Boolean>{

        private Context context;

        public CheckIsItFavoriteAsync(Context context) {
            this.context = context;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            return AppDatabase.getInstance(context).favoriteGifDAO().isFavoriteGIf(strings[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            isFavorite.setValue(aBoolean);
        }
    }

    public void setIsFavoriteGif(Context context, boolean isFavorite){

        FavoriteGif favoriteGif = new FavoriteGif();
        favoriteGif.setId(resultsItem.getValue().get(0).getId());
        favoriteGif.setGifUrl(resultsItem.getValue().get(0).getMedia().get(0).getGif().getUrl());

        if (isFavorite){
            new InsertAsync(context, favoriteGif).execute();
        } else {
            new DeleteAsync(context, favoriteGif).execute();
        }
    }

    private class InsertAsync extends AsyncTask<Void, Void, Void>{
        private Context context;
        private FavoriteGif favoriteGif;

        public InsertAsync(Context context, FavoriteGif favoriteGif) {
            this.context = context;
            this.favoriteGif = favoriteGif;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase.getInstance(context).favoriteGifDAO().insert(favoriteGif);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            isFavorite.setValue(true);
        }
    }

    private class DeleteAsync extends AsyncTask<Void, Void, Void>{
        private Context context;
        private FavoriteGif favoriteGif;

        public DeleteAsync(Context context, FavoriteGif favoriteGif) {
            this.context = context;
            this.favoriteGif = favoriteGif;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            AppDatabase.getInstance(context).favoriteGifDAO().delete(favoriteGif);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            isFavorite.setValue(false);
        }
    }
}
