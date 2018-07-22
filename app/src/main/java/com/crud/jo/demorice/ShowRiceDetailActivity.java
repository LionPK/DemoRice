package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowRiceDetailActivity extends AppCompatActivity {
    private String rice_image;
    private String rice_name;
    private String rice_detail;
    private ImageView imageView;
    private TextView tvRiceName;
    private TextView tvRiceDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rice_detail);

        initInstances();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_rice_detail_back) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        Main.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initInstances() {

        rice_image = getIntent().getStringExtra("rice_image");
        rice_name = getIntent().getStringExtra("name");
        rice_detail = getIntent().getStringExtra("detail");

        imageView = (ImageView) findViewById(R.id.riceImageView);
        tvRiceName = (TextView) findViewById(R.id.nameTextView);
        tvRiceDescription = (TextView) findViewById(R.id.detailTextView);

        Glide.with(this).load(rice_image).into(imageView);
        tvRiceName.setText(rice_name);
        tvRiceDescription.setText(rice_detail);
    }
}
