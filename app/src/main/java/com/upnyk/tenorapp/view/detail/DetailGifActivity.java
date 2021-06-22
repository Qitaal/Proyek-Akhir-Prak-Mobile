package com.upnyk.tenorapp.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upnyk.tenorapp.R;
import com.upnyk.tenorapp.service.model.ResultsItem;

import java.util.List;

public class DetailGifActivity extends AppCompatActivity {

    private DetailGifViewModel detailGifViewModel;

    private ImageView ivDetail;
    private FloatingActionButton fabShare, fabFavorite;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gif);

        detailGifViewModel = new ViewModelProvider(this).get(DetailGifViewModel.class);

        id = getIntent().getStringExtra("EXTRA_ID");
        detailGifViewModel.getDetail(id);
        detailGifViewModel.checkIsItFavorite(this, id);

        ivDetail = findViewById(R.id.iv_detail);
        fabFavorite = findViewById(R.id.fab_favorite);
        fabShare = findViewById(R.id.fab_share);

        detailGifViewModel.getResultsItem().observe(this, resultsItems -> {
            Glide.with(DetailGifActivity.this)
                    .asGif()
                    .load(resultsItems.get(0).getMedia().get(0).getGif().getUrl())
                    .placeholder(R.drawable.loading)
                    .into(ivDetail);

            fabShare.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(resultsItems.get(0).getUrl()));
                startActivity(intent);
            });
        });

        detailGifViewModel.getIsFavorite().observe(this, aBoolean -> {
            if (aBoolean) {
                fabFavorite.setImageDrawable(getDrawable(R.drawable.ic_baseline_favorite_24));
            } else {
                fabFavorite.setImageDrawable(getDrawable(R.drawable.ic_baseline_favorite_border_24));
            }
        });

        fabFavorite.setOnClickListener(v -> {
            if (detailGifViewModel.getIsFavorite().getValue()){
                detailGifViewModel.setIsFavoriteGif(this, false);
            } else {
                detailGifViewModel.setIsFavoriteGif(this, true);
            }
        });
    }
}