package com.upnyk.tenorapp.view.favorite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.upnyk.tenorapp.R;
import com.upnyk.tenorapp.database.FavoriteGif;
import com.upnyk.tenorapp.view.detail.DetailGifActivity;

import java.util.List;

public class FavoriteGifAdapter extends RecyclerView.Adapter<FavoriteGifAdapter.ViewHolder> {

    private List<FavoriteGif> favoriteGif;
    private Context context;

    public FavoriteGifAdapter(List<FavoriteGif> favoriteGif, Context context) {
        this.favoriteGif = favoriteGif;
        this.context = context;
    }

    public void setFavoriteGif(List<FavoriteGif> favoriteGif) {
        this.favoriteGif = favoriteGif;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteGifAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return favoriteGif.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_list);
        }

        public void bind(int position) {
            Glide.with(context)
                    .asGif()
                    .load(favoriteGif.get(position).getGifUrl())
                    .placeholder(R.drawable.loading)
                    .into(imageView);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailGifActivity.class);
                intent.putExtra("EXTRA_ID", favoriteGif.get(position).getId());
                context.startActivity(intent);
            });
        }
    }
}
