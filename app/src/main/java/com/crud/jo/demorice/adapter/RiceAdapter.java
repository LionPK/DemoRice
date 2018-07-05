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
import com.crud.jo.demorice.model.Rice;

import java.util.ArrayList;

public class RiceAdapter extends RecyclerView.Adapter<RiceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Rice> riceArrayList;

    public RiceAdapter(Context context, ArrayList<Rice> riceArrayList) {
        this.context = context;
        this.riceArrayList = riceArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rice rice = riceArrayList.get(position);
        Glide.with(context).load(rice.getRiceImg()).into(holder.riceImageView);
        holder.nameTextView.setText(rice.getNameRice());
        holder.detailTextView.setText(rice.getDetailRice());
        holder.typeTextView.setText(rice.getTypeRice());
    }

    @Override
    public int getItemCount() {
        return riceArrayList.size() != 0 ? riceArrayList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView riceImageView;
        TextView nameTextView;
        TextView typeTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            riceImageView = itemView.findViewById(R.id.riceImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);
        }
    }
}
