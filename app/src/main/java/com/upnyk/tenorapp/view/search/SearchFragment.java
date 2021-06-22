package com.upnyk.tenorapp.view.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.upnyk.tenorapp.adapter.GifListAdapter;
import com.upnyk.tenorapp.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private TextInputLayout textInputLayout;
    private TextInputEditText etSearch;
    private RecyclerView rvSearch;
    private GifListAdapter gifListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        textInputLayout = view.findViewById(R.id.text_input_layout);
        etSearch = view.findViewById(R.id.et_search);
        rvSearch = view.findViewById(R.id.rv_search);
        gifListAdapter = new GifListAdapter(new ArrayList<>(), getActivity());

        rvSearch.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvSearch.setHasFixedSize(true);
        rvSearch.setAdapter(gifListAdapter);

        searchViewModel.getGifList().observe(requireActivity(), resultsItems -> {
            gifListAdapter.setResultsItems(resultsItems);
            gifListAdapter.notifyDataSetChanged();
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchViewModel.searchGif(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {
                searchViewModel.searchGif(String.valueOf(s));
            }
        });
    }
}