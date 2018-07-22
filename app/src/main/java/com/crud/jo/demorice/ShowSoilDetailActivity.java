package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowSoilDetailActivity extends AppCompatActivity {
    private String soil_image;
    private String soil_detail;
    private String soil_type;
    private ImageView ImageView;
    private TextView tvsoilType;
    private TextView tvsoilDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_soil_detail);
        initInstances();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_backsoil) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        soil_list.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initInstances() {

        soil_image = getIntent().getStringExtra("soil_image");
        soil_type = getIntent().getStringExtra("type");
        soil_detail = getIntent().getStringExtra("detail");

        ImageView = (ImageView) findViewById(R.id.soilImageView);
        tvsoilType = (TextView) findViewById(R.id.typeTextView);
        tvsoilDescription = (TextView) findViewById(R.id.detailTextView);

        Glide.with(this).load(soil_image).into(ImageView);
        tvsoilDescription.setText(soil_detail);
        tvsoilType.setText(soil_type);
    }
}