package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowFertilizerDetailActivity extends AppCompatActivity {

    private String fertilizer_image;
    private String fertilizer_name;
    private String fertilizer_detail;
    private ImageView imageView;
    private TextView tvFertilizerName;
    private TextView tvFertilizerDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fertilizer_detail);

        initInstances();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_fertilizer_detail_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        ferilizer_list.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initInstances() {

        fertilizer_image = getIntent().getStringExtra("fertilizer_image");
        fertilizer_name = getIntent().getStringExtra("name");
        fertilizer_detail = getIntent().getStringExtra("detail");

        imageView = (ImageView) findViewById(R.id.fertilizerImageView);
        tvFertilizerName = (TextView) findViewById(R.id.nameTextView);
        tvFertilizerDescription = (TextView) findViewById(R.id.detailTextView);

        Glide.with(this).load(fertilizer_image).into(imageView);
        tvFertilizerName.setText(fertilizer_name);
        tvFertilizerDescription.setText(fertilizer_detail);
    }
}
