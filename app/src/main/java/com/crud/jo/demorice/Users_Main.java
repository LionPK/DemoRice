package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Users_Main extends AppCompatActivity {
    private ImageButton btn_rice_member;
    private ImageButton btn_pest_member;
    private ImageButton btn_soil_member;
    private ImageButton btn_fertilizer_member;
    private ImageButton btn_analyst_member;
    private ImageButton btn_user_member;
    private ImageButton btn_weather_member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users__main);

        btn_rice_member = (ImageButton) findViewById(R.id.btn_rice_member);
        btn_pest_member = (ImageButton) findViewById(R.id.btn_pest_member);
        btn_soil_member = (ImageButton) findViewById(R.id.btn_soil_member);
        btn_fertilizer_member = (ImageButton) findViewById(R.id.btn_fertilizer_member);
        btn_analyst_member = (ImageButton) findViewById(R.id.btn_analyst_member);
        btn_user_member = (ImageButton) findViewById(R.id.btn_user_member);
        btn_weather_member = (ImageButton) findViewById(R.id.btn_weather_member);

        btn_rice_member.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(Users_Main.this,
                    Main.class);
            startActivity(i);
            finish();
        }
    });

        btn_pest_member.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(Users_Main.this,
                    weed_list.class);
            startActivity(i);
            finish();
        }
    });

        btn_soil_member.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(Users_Main.this,
                    soil_list.class);
            startActivity(i);
            finish();
        }
    });
        btn_fertilizer_member.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(Users_Main.this,
                    ferilizer_list.class);
            startActivity(i);
            finish();
        }
    });
        btn_analyst_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Users_Main.this,
                        ferilizer_list.class);
                startActivity(i);
                finish();
            }
        });
        btn_user_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Users_Main.this,
                        ferilizer_list.class);
                startActivity(i);
                finish();
            }
        });

        btn_weather_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Users_Main.this,
                        WeatherActivity.class);
                startActivity(i);
                finish();
            }
        });
}
}

