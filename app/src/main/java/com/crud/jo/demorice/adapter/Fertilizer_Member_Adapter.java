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
import com.crud.jo.demorice.ShowFertilizerMemberDetailActivity;
import com.crud.jo.demorice.model.Fertilizer;

import java.util.ArrayList;

public class Fertilizer_Member_Adapter extends RecyclerView.Adapter<Fertilizer_Member_Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Fertilizer> fertilizerArrayList;

    public Fertilizer_Member_Adapter(Context context, ArrayList<Fertilizer> fertilizerArrayList) {
        this.context = context;
        this.fertilizerArrayList = fertilizerArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fertilizer_member_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fertilizer fertilizer = fertilizerArrayList.get(position);
        Glide.with(context).load(fertilizer.getFerImg()).into(holder.ferImageView);
        holder.nameTextView.setText(fertilizer.getNamefertilizer());
        holder.detailTextView.setText(fertilizer.getDetailfertilizer());
        holder.typeTextView.setText(fertilizer.getTypefertilizer());

        final String name = fertilizer.getNamefertilizer();
        final String detail = fertilizer.getDetailfertilizer();
        final String fertilizer_image = fertilizer.getFerImg();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(name, detail, fertilizer_image);
            }
        });
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
            ferImageView = itemView.findViewById(R.id.ferImagememberView);
            nameTextView = itemView.findViewById(R.id.name_fermember);
            typeTextView = itemView.findViewById(R.id.type_fermember);
            detailTextView = itemView.findViewById(R.id.detail_fermember);
        }
    }

    private void openDetailActivity(String... details) {

        Intent intent = new Intent(context, ShowFertilizerMemberDetailActivity.class);
        intent.putExtra("name", details[0]);
        intent.putExtra("detail", details[1]);
        intent.putExtra("fertilizer_image", details[2]);

        context.startActivity(intent);
    }
}
