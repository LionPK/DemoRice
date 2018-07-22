package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowWeedMemberDetailActivity extends AppCompatActivity {

    private String weed_image;
    private String weed_name;
    private String weed_detail;
    private ImageView imageView;
    private TextView tvWeedName;
    private TextView tvWeedDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weed_member_detail);

        initInstances();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_weed_detail_back) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        WeedMember_list.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initInstances() {

        weed_image = getIntent().getStringExtra("weed_image");
        weed_name = getIntent().getStringExtra("name");
        weed_detail = getIntent().getStringExtra("detail");

        imageView = (ImageView) findViewById(R.id.weedImageView);
        tvWeedName = (TextView) findViewById(R.id.nameTextView);
        tvWeedDescription = (TextView) findViewById(R.id.detailTextView);

        Glide.with(this).load(weed_image).into(imageView);
        tvWeedName.setText(weed_name);
        tvWeedDescription.setText(weed_detail);
    }
}
