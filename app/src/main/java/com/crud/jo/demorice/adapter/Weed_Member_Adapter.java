package com.crud.jo.demorice.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crud.jo.demorice.R;
import com.crud.jo.demorice.model.Weed;

import java.util.ArrayList;

public class Weed_Member_Adapter extends RecyclerView.Adapter<Weed_Member_Adapter.ViewHolder> {
    private Context context;
    private ArrayList <Weed> weedArrayList;

    public Weed_Member_Adapter(Context context, ArrayList<Weed> weedArrayList) {
        this.context = context;
        this.weedArrayList = weedArrayList;
    }

    @NonNull
    @Override
    public Weed_Member_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weed weed = weedArrayList.get(position);
        Glide.with(context).load(weed.getWeedImg()).into(holder.ImageweedView);
        holder.weenameView.setText(weed.getNameWeed());
        holder.typeTextView.setText(weed.getTypeWeed());
        holder.detailTextView.setText(weed.getDetailWeed());
    }

    @Override
    public int getItemCount() {
        return weedArrayList.size() != 0 ? weedArrayList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ImageweedView;
        TextView weenameView;
        TextView typeTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageweedView = itemView.findViewById(R.id.weedImageView);
            weenameView = itemView.findViewById(R.id.weedNameView);
            typeTextView = itemView.findViewById(R.id.type_weed);
            detailTextView = itemView.findViewById(R.id.detail_weed);
        }
    }
}
