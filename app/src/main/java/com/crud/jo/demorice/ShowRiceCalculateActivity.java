package com.crud.jo.demorice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowRiceCalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rice_calculate);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Message");

        TextView impact_data = (TextView)findViewById(R.id.data_TextView);
        impact_data.setText(data);
    }
}
