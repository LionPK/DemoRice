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
import com.crud.jo.demorice.ShowSoilMemberDetailActivity;
import com.crud.jo.demorice.model.Rice;
import com.crud.jo.demorice.model.Soil;

import java.util.ArrayList;

public class Soil_Member_Adapter  extends RecyclerView.Adapter<Soil_Member_Adapter.ViewHolder>{

    private Context context;
    private ArrayList <Soil> soilArrayList;

    public Soil_Member_Adapter(Context context, ArrayList <Soil> soilArrayList) {
        this.context = context;
        this.soilArrayList = soilArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.soil_member_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Soil soil = soilArrayList.get(position);
        Glide.with(context).load(soil.getSoilImg()).into(holder.soileImageView);
        holder.detailTextView.setText(soil.getDetailSoil());
        holder.typeTextView.setText(soil.getTypeSoil());

        final String type = soil.getTypeSoil();
        final String detail = soil.getDetailSoil();
        final String soil_image = soil.getSoilImg();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(type, detail, soil_image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return soilArrayList.size() != 0 ? soilArrayList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView soileImageView;
        TextView typeTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soileImageView = itemView.findViewById(R.id.soilImageView_member);
            typeTextView = itemView.findViewById(R.id.typeTextView_member);
            detailTextView = itemView.findViewById(R.id.detailTextView_member);
        }
    }

    private void openDetailActivity(String... details) {

        Intent intent = new Intent(context, ShowSoilMemberDetailActivity.class);
        intent.putExtra("type", details[0]);
        intent.putExtra("detail", details[1]);
        intent.putExtra("soil_image", details[2]);

        context.startActivity(intent);
    }
}
