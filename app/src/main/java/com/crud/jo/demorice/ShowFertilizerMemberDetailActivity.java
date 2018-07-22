package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowFertilizerMemberDetailActivity extends AppCompatActivity {

    private String fer_image;
    private String fer_name;
    private String fer_detail;
    private ImageView imageView;
    private TextView tvFerName;
    private TextView tvFerDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fertilizer_member_detail);

        initInstances();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_fer_detail_back) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        FertilizerMember_list.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initInstances() {

        fer_image = getIntent().getStringExtra("fertilizer_image");
        fer_name = getIntent().getStringExtra("name");
        fer_detail = getIntent().getStringExtra("detail");

        imageView = (ImageView) findViewById(R.id.ferImageView);
        tvFerName = (TextView) findViewById(R.id.nameTextView);
        tvFerDescription = (TextView) findViewById(R.id.detailTextView);

        Glide.with(this).load(fer_image).into(imageView);
        tvFerName.setText(fer_name);
        tvFerDescription.setText(fer_detail);
    }
}
