package com.crud.jo.demorice;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowRiceCalculateActivity extends AppCompatActivity {

    private int[] rice_picture = {
            R.drawable.icon_0,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rice_calculate);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Message");
        Integer pic = bundle.getInt("Picture");

        TextView impact_data = (TextView)findViewById(R.id.data_TextView);
        impact_data.setText(data);

        Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.icon_0)).getBitmap();
        ImageView image = (ImageView)findViewById(R.id.rice_picture);
        image.setImageBitmap(pc);
    }
}
