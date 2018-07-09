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
import com.crud.jo.demorice.model.Fertilizer;
import java.util.ArrayList;

public class FertilizerAdapter extends RecyclerView.Adapter<FertilizerAdapter.ViewHolder> {

    private Context context;
    private ArrayList <Fertilizer> fertilizerArrayList;

    public FertilizerAdapter(Context context, ArrayList <Fertilizer> fertilizerArrayList) {
        this.context = context;
        this.fertilizerArrayList = fertilizerArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ferilizer_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fertilizer fertilizer = fertilizerArrayList.get(position);
        Glide.with(context).load(fertilizer.getFerImg()).into(holder.ferImageView);
        holder.nameTextView.setText(fertilizer.getNamefertilizer());
        holder.detailTextView.setText(fertilizer.getDetailfertilizer());
        holder.typeTextView.setText(fertilizer.getTypefertilizer());
    }

    @Override
    public int getItemCount() {
        return fertilizerArrayList.size() != 0 ? fertilizerArrayList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ferImageView;
        TextView nameTextView;
        TextView typeTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ferImageView = itemView.findViewById(R.id.ferImageView);
            nameTextView = itemView.findViewById(R.id.name_fer);
            typeTextView = itemView.findViewById(R.id.type_fer);
            detailTextView = itemView.findViewById(R.id.detail_fer);
        }
    }
}
