package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowSoilMemberDetailActivity extends AppCompatActivity {

    private String soil_image;
    private String soil_type;
    private String soil_detail;
    private ImageView imageView;
    private TextView tvSoilType;
    private TextView tvSoilDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_soil_member_detail);

        initInstances();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_soil_detail_back) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        SoilMember_list.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initInstances() {

        soil_image = getIntent().getStringExtra("soil_image");
        soil_type = getIntent().getStringExtra("type");
        soil_detail = getIntent().getStringExtra("detail");

        imageView = (ImageView) findViewById(R.id.soilImageView);
        tvSoilType = (TextView) findViewById(R.id.typeTextView);
        tvSoilDescription = (TextView) findViewById(R.id.detailTextView);

        Glide.with(this).load(soil_image).into(imageView);
        tvSoilType.setText(soil_type);
        tvSoilDescription.setText(soil_detail);
    }
}
