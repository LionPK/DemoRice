package com.crud.jo.demorice.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crud.jo.demorice.R;
import com.crud.jo.demorice.ShowWeedDetailActivity;
import com.crud.jo.demorice.model.Weed;

import java.util.ArrayList;

public class WeedAdapter extends RecyclerView.Adapter<WeedAdapter.ViewHolder> {
    private Context context;
    private ArrayList <Weed> weedArrayList;

    public WeedAdapter(Context context, ArrayList<Weed> weedArrayList) {
        this.context = context;
        this.weedArrayList = weedArrayList;
    }

    @NonNull
    @Override
    public WeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weed, parent, false);
        return new WeedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeedAdapter.ViewHolder holder, int position) {
        Weed weed = weedArrayList.get(position);
        Glide.with(context).load(weed.getWeedImg()).into(holder.ImageWeedView);
        holder.weedNameView.setText(weed.getNameWeed());
        holder.typeTextView.setText(weed.getTypeWeed());
        holder.detailTextView.setText(weed.getDetailWeed());

        final String name = weed.getNameWeed();
        final String detail = weed.getDetailWeed();
        final String weed_image = weed.getWeedImg();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(name, detail,weed_image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return weedArrayList.size() != 0 ? weedArrayList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ImageWeedView;
        TextView weedNameView;
        TextView typeTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageWeedView = itemView.findViewById(R.id.weedImageView);
            weedNameView = itemView.findViewById(R.id.weedNameView);
            typeTextView = itemView.findViewById(R.id.type_weed);
            detailTextView = itemView.findViewById(R.id.detail_weed);
        }
    }

    private void openDetailActivity(String... details) {

        Intent intent = new Intent(context, ShowWeedDetailActivity.class);
        intent.putExtra("name", details[0]);
        intent.putExtra("detail", details[1]);
        intent.putExtra("weed_image", details[2]);

        context.startActivity(intent);
    }
}
