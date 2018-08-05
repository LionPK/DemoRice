package com.crud.jo.demorice;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowRiceCalculateActivity extends AppCompatActivity {

    private int[] rice_picture = {
            R.drawable.rice0001,
            R.drawable.rice0070,
            R.drawable.rice0109,
            R.drawable.rice0168,
            R.drawable.rice0227,
            R.drawable.rice0286,
            R.drawable.rice0345,
            R.drawable.rice0463,
            R.drawable.rice0522,
            R.drawable.rice0577,
            //soil
            R.drawable.soil0001,
            //weed
            R.drawable.weed0070,
            R.drawable.weed0168,
            R.drawable.weed0286,
            R.drawable.weed0463,
            R.drawable.weed0523,
            //fertilizer
            R.drawable.fer0001,
            R.drawable.fer0002,
            R.drawable.fer0004,
            R.drawable.fer0006l,
            R.drawable.fer0007,
            R.drawable.fer0008,
            R.drawable.fer0009,
            R.drawable.fer013,
            R.drawable.fer0146,
            R.drawable.fer0149,
            R.drawable.fer0237,//เพื่มรูปภาพ

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rice_calculate);

        Bundle bundle = getIntent().getExtras();
        String data0 = bundle.getString("Messagerice_type");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data1 = bundle.getString("Messageweather_napee");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data2 = bundle.getString("Messageweather_napung");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data3 = bundle.getString("MessageChemical_fertilizer");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data4 = bundle.getString("MessageBio_fertilizer");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data5 = bundle.getString("Messageadjust_soil");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data6 = bundle.getString("Messagesoil_type");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data7 = bundle.getString("Messageweed_type");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data8 = bundle.getString("Messageweed_Removal");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data9 = bundle.getString("Messagedayrice_napung");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data10 = bundle.getString("Messagericedisease_name");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data11 = bundle.getString("Messagericedisease_Removal");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data12 = bundle.getString("Messagerice_method_one");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data13 = bundle.getString("Messagerice_method_two");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        String data14 = bundle.getString("Messagerice_method_three");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        Integer pic = bundle.getInt("Picture");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea

        TextView impact_data0 = (TextView)findViewById(R.id.rice_typr);
        impact_data0.setText(data0);
        TextView impact_data = (TextView)findViewById(R.id.weather_napee);
        impact_data.setText(data1);
        TextView impact_data1 = (TextView)findViewById(R.id.weather_napee);
        impact_data1.setText(data2);
        TextView impact_data2 = (TextView)findViewById(R.id.weather_napung);
        impact_data2.setText(data3);
        TextView impact_data3 = (TextView)findViewById(R.id.chemical_fertilizer);
        impact_data3.setText(data4);
        TextView impact_data4 = (TextView)findViewById(R.id.bio_fertilizer);
        impact_data4.setText(data5);
        TextView impact_data5 = (TextView)findViewById(R.id.adjust_soil);
        impact_data5.setText(data6);
        TextView impact_data6 = (TextView)findViewById(R.id.soil_type);
        impact_data6.setText(data7);
        TextView impact_data7 = (TextView)findViewById(R.id.weed_type);
        impact_data7.setText(data8);
        TextView impact_data8 = (TextView)findViewById(R.id.dayrice_napung);
        impact_data8.setText(data9);
        TextView impact_data9 = (TextView)findViewById(R.id.ricedisease_name);
        impact_data9.setText(data10);
        TextView impact_data10 = (TextView)findViewById(R.id.ricedisease_Removal);
        impact_data10.setText(data11);
        TextView impact_data11 = (TextView)findViewById(R.id.rice_method_one);
        impact_data11.setText(data12);
        TextView impact_data12 = (TextView)findViewById(R.id.rice_method_two);
        impact_data12.setText(data13);
        TextView impact_data13 = (TextView)findViewById(R.id.rice_method_three);
        impact_data13.setText(data14);


        Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
        ImageView image = (ImageView)findViewById(R.id.riceImageView);
        image.setImageBitmap(pc);
        Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
        ImageView image1 = (ImageView)findViewById(R.id.soilImageView);
        image1.setImageBitmap(pc1);
        Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0001)).getBitmap();
        ImageView image2 = (ImageView)findViewById(R.id.ferImagememberView);
        image2.setImageBitmap(pc2);

    }
}
