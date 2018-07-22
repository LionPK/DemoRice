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
import com.crud.jo.demorice.ShowSoilDetailActivity;
import com.crud.jo.demorice.ShowWeedDetailActivity;
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

        final String detailSoil = soil.getDetailSoil();
        final String Type = soil.getTypeSoil();
        final String img_image = soil.getSoilImg();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(Type,detailSoil,img_image);
            }
        });
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
    private void openDetailActivity(String... details) {

        Intent intent = new Intent(context, ShowSoilDetailActivity.class);
        intent.putExtra("type", details[0]);
        intent.putExtra("detail", details[1]);
        intent.putExtra("soil_image", details[2]);

        context.startActivity(intent);
    }
}

