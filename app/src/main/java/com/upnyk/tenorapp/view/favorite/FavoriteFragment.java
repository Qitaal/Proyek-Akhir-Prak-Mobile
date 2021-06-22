package com.upnyk.tenorapp.view.favorite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upnyk.tenorapp.GifListAdapter;
import com.upnyk.tenorapp.R;
import com.upnyk.tenorapp.database.FavoriteGif;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel favoriteViewModel;
    private RecyclerView rvFavorite;
    private FavoriteGifAdapter favoriteGifAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoriteViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);

        rvFavorite = view.findViewById(R.id.rv_favorite);
        favoriteGifAdapter = new FavoriteGifAdapter(new ArrayList<>(), getActivity());

        rvFavorite.setHasFixedSize(true);
        rvFavorite.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvFavorite.setAdapter(favoriteGifAdapter);

        favoriteViewModel.getFavoriteGif().observe(requireActivity(), favoriteGifs -> {
            favoriteGifAdapter.setFavoriteGif(favoriteGifs);
            favoriteGifAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        favoriteViewModel.refreshFavoriteGif(getActivity());
    }
}