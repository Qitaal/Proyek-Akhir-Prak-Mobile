package com.upnyk.tenorapp.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upnyk.tenorapp.adapter.GifListAdapter;
import com.upnyk.tenorapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rvTrending;
    private GifListAdapter gifListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        rvTrending = view.findViewById(R.id.rv_home);
        gifListAdapter = new GifListAdapter(new ArrayList<>(), getActivity());

        rvTrending.setHasFixedSize(true);
        rvTrending.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvTrending.setAdapter(gifListAdapter);

        homeViewModel.getGifList().observe(requireActivity(), resultsItems -> {
            gifListAdapter.setResultsItems(resultsItems);
            gifListAdapter.notifyDataSetChanged();
        });

        homeViewModel.loadTrending();
    }
}