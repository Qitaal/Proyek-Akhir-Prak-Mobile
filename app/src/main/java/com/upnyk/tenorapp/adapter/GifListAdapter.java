package com.upnyk.tenorapp.adapter;

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
import com.upnyk.tenorapp.service.model.ResultsItem;
import com.upnyk.tenorapp.view.detail.DetailGifActivity;

import java.util.List;

public class GifListAdapter extends RecyclerView.Adapter<GifListAdapter.ViewHolder> {

    private List<ResultsItem> resultsItems;
    private Context context;

    public GifListAdapter(List<ResultsItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }

    public void setResultsItems(List<ResultsItem> resultsItems) {
        this.resultsItems = resultsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GifListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
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
                    .load(resultsItems.get(position).getMedia().get(0).getNanogif().getUrl())
                    .placeholder(R.drawable.loading)
                    .into(imageView);

            itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(context, DetailGifActivity.class);
                    intent.putExtra("EXTRA_ID", resultsItems.get(position).getId());
                    context.startActivity(intent);
            });
        }
    }
}
