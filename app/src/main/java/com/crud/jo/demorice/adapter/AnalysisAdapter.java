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
import com.crud.jo.demorice.ShowRiceDetailActivity;
import com.crud.jo.demorice.model.Analysis;
import com.crud.jo.demorice.model.Rice;

import java.util.ArrayList;

public class AnalysisAdapter extends RecyclerView.Adapter<AnalysisAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Analysis> analysisArrayList;

    public AnalysisAdapter (Context context, ArrayList<Analysis> analysisArrayList) {
        this.context = context;
        this.analysisArrayList = analysisArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.analysis_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Analysis analysis = analysisArrayList.get(position);
        Glide.with(context).load(analysis.getAnaly1_id()).into(holder.riceImageView);
        holder.nameTextView.setText(analysis.getNameRice());
        holder.detailTextView.setText(analysis.getDetailRice());
        holder.typeTextView.setText(analysis.getTypeRice());

        final String name = analysis.getNameRice();
        final String detail = analysis.getDetailRice();
        final String rice_image = analysis.getRiceImg();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(name, detail, rice_image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return analysisArrayList.size() != 0 ? analysisArrayList.size() : 0;
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

    private void openDetailActivity(String... details) {

        Intent intent = new Intent(context, ShowRiceDetailActivity.class);
        intent.putExtra("name", details[0]);
        intent.putExtra("detail", details[1]);
        intent.putExtra("rice_image", details[2]);

        context.startActivity(intent);
    }
}
