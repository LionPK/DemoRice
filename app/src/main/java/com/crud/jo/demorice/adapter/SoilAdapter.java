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
import com.crud.jo.demorice.model.Soil;

import java.util.ArrayList;

public class SoilAdapter extends RecyclerView.Adapter<SoilAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Soil> soilArrayList;

    public SoilAdapter(Context context, ArrayList<Soil> soilArrayList) {
        this.context = context;
        this.soilArrayList = soilArrayList;
    }

    @NonNull
    @Override
    public SoilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.soil_list, parent, false);
        return new SoilAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoilAdapter.ViewHolder holder, int position) {
        Soil soil = soilArrayList.get(position);
        Glide.with(context).load(soil.getSoilImg()).into(holder.soilImageView);
        holder.detailTextView.setText(soil.getDetailSoil());
        holder.typeTextView.setText(soil.getTypeSoil());
    }

    @Override
    public int getItemCount() {
        return soilArrayList.size() != 0 ? soilArrayList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView soilImageView;
        TextView typeTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soilImageView = itemView.findViewById(R.id.soilImageView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);
        }
    }
}

