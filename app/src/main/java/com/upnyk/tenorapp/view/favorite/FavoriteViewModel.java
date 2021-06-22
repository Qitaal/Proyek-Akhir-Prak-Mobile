package com.upnyk.tenorapp.view.favorite;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.tenorapp.database.AppDatabase;
import com.upnyk.tenorapp.database.FavoriteGif;

import java.util.List;

public class FavoriteViewModel extends ViewModel {

    private MutableLiveData<List<FavoriteGif>> favoriteGif;

    public FavoriteViewModel() {
        favoriteGif = new MutableLiveData<>();
    }

    public MutableLiveData<List<FavoriteGif>> getFavoriteGif() {
        return favoriteGif;
    }

    public void refreshFavoriteGif(Context context){
        new GetFavoriteGif(context).execute();
    }

    private class GetFavoriteGif extends AsyncTask<Void, Void, List<FavoriteGif>> {
        private Context context;
        public GetFavoriteGif(Context context) {
            this.context = context;
        }

        @Override
        protected List<FavoriteGif> doInBackground(Void... voids) {
            return AppDatabase.getInstance(context).favoriteGifDAO().getFavoriteGif();
        }

        @Override
        protected void onPostExecute(List<FavoriteGif> favoriteGifs) {
            super.onPostExecute(favoriteGifs);
            favoriteGif.setValue(favoriteGifs);
        }
    }
}
