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
import com.crud.jo.demorice.ShowRiceMemberDetailActivity;
import com.crud.jo.demorice.model.Rice;
import java.util.ArrayList;

public class Rice_Member_Adapter  extends RecyclerView.Adapter<Rice_Member_Adapter.ViewHolder>{

    private Context context;
    private ArrayList <Rice> riceArrayList_m;

    public Rice_Member_Adapter(Context context, ArrayList <Rice> riceArrayList) {
        this.context = context;
        this.riceArrayList_m = riceArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rice_member_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rice rice = riceArrayList_m.get(position);
        Glide.with(context).load(rice.getRiceImg()).into(holder.riceImageView);
        holder.nameTextView.setText(rice.getNameRice());
        holder.detailTextView.setText(rice.getDetailRice());
        holder.typeTextView.setText(rice.getTypeRice());

        final String name = rice.getNameRice();
        final String detail = rice.getDetailRice();
        final String rice_image = rice.getRiceImg();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(name, detail, rice_image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return riceArrayList_m.size() != 0 ? riceArrayList_m.size() : 0;
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

        Intent intent = new Intent(context, ShowRiceMemberDetailActivity.class);
        intent.putExtra("name", details[0]);
        intent.putExtra("detail", details[1]);
        intent.putExtra("rice_image", details[2]);

        context.startActivity(intent);
    }
}
