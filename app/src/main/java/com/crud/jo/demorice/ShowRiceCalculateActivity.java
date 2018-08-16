package com.crud.jo.demorice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowRiceCalculateActivity extends AppCompatActivity {

    private int[] rice_picture = {//ใส่รูปภาพที่จะไปแสดง
            //rice
            R.drawable.rice0001,//0
            R.drawable.rice0070,//1
            R.drawable.rice0109,//2
            R.drawable.rice0168,//3
            R.drawable.rice0227,//4
            R.drawable.rice0286,//5
            R.drawable.rice0345,//6
            R.drawable.rice0463,//7
            R.drawable.rice0522,//8
            R.drawable.rice0577,//9
    };
    private int[] soil_picture = {
            //soil
            R.drawable.soil0001,};//0
    private int[] weed_picture = {
            //weed
            R.drawable.weed0070,//0
            R.drawable.weed0168,//1
            R.drawable.weed0286,//2
            R.drawable.weed0463,//3
            R.drawable.weed0523,//4
            R.drawable.logo,//5
    };
    private int[] fer_picture = {
            //fertilizer
            R.drawable.fer0001,//0
            R.drawable.fer0002,//1
            R.drawable.fer0004,//2
            R.drawable.fer0006l,//3
            R.drawable.fer0007,//4
            R.drawable.fer0008,//5
            R.drawable.fer0009,//6
            R.drawable.fer013,//7
            R.drawable.fer0146,//8
            R.drawable.fer0149,//9
            R.drawable.fer0237,//10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rice_calculate);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_back) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        AnalysisArea.class);
                startActivity(i);
                finish();
            }
        });

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
        Integer pic1 = bundle.getInt("Picture1");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        Integer pic2 = bundle.getInt("Picture2");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        Integer pic3 = bundle.getInt("Picture3");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea
        Integer pic4 = bundle.getInt("Picture4");//ข้อความต้องตรงกลับที่ส่งมาในหน้า analysisArea

        TextView impact_data0 = (TextView)findViewById(R.id.rice_typr);
        impact_data0.setText(data0);
        TextView impact_data = (TextView)findViewById(R.id.weather_napee);
        impact_data.setText(data1);
        TextView impact_data1 = (TextView)findViewById(R.id.weather_napung);
        impact_data1.setText(data2);
        TextView impact_data2 = (TextView)findViewById(R.id.rice_area);
        impact_data2.setText(data3);
        TextView impact_data3 = (TextView)findViewById(R.id.chemical_fertilizer);
        impact_data3.setText(data4);
        TextView impact_data4 = (TextView)findViewById(R.id.bio_fertilizer);
        impact_data4.setText(data5);
        TextView impact_data5 = (TextView)findViewById(R.id.soil_type);
        impact_data5.setText(data6);
        TextView impact_data6 = (TextView)findViewById(R.id.adjust_soil);
        impact_data6.setText(data7);
        TextView impact_data7 = (TextView)findViewById(R.id.weed_type);
        impact_data7.setText(data8);
        TextView impact_data8 = (TextView)findViewById(R.id.weed_removal);
        impact_data8.setText(data9);
        TextView impact_data9 = (TextView)findViewById(R.id.dayrice_napung);
        impact_data9.setText(data10);
        TextView impact_data10 = (TextView)findViewById(R.id.ricedisease_Removal);
        impact_data10.setText(data11);
        TextView impact_data11 = (TextView)findViewById(R.id.rice_method_one);
        impact_data11.setText(data12);
        TextView impact_data12 = (TextView)findViewById(R.id.rice_method_two);
        impact_data12.setText(data13);
        TextView impact_data13 = (TextView)findViewById(R.id.rice_method_three);
        impact_data13.setText(data14);


        if(pic1 == rice_picture[0] && pic2 == weed_picture[5] &&pic3 == soil_picture[0] && pic4 == fer_picture[0]){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0001)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
        else if(pic1 == rice_picture[0] && pic2== weed_picture[5] && pic3 == soil_picture[0] && pic4 == fer_picture[1] ){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0002)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
        else if(pic1 == rice_picture[0] && pic2 == weed_picture[5] && pic3 == soil_picture[0] && pic4 == fer_picture[2] ){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0004)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
        else if(pic1 == rice_picture[0] && pic2== weed_picture[5] && pic3== soil_picture[0] && pic4 == fer_picture[3] ){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0006l)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
        else if(pic1 == rice_picture[0] && pic2 == weed_picture[5] && pic3 == soil_picture[0] && pic4 == fer_picture[4] ){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0007)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
        else if(pic1 == rice_picture[0] && pic2 == weed_picture[5] && pic3 == soil_picture[0] && pic4 == fer_picture[5] ){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0008)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
        else if(pic1 == rice_picture[0] && pic2 == weed_picture[5] && pic3 == soil_picture[0] && pic4 == fer_picture[6] ){
            Bitmap pc = ((BitmapDrawable) getResources().getDrawable(R.drawable.rice0001)).getBitmap();
            ImageView image = (ImageView)findViewById(R.id.riceImageView);
            image.setImageBitmap(pc);
            Bitmap pc1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.logo)).getBitmap();
            ImageView image1 = (ImageView)findViewById(R.id.weedImageView);
            image1.setImageBitmap(pc1);
            Bitmap pc2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.soil0001)).getBitmap();
            ImageView image2 = (ImageView)findViewById(R.id.soilImageView);
            image2.setImageBitmap(pc2);
            Bitmap pc3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.fer0009)).getBitmap();
            ImageView image3 = (ImageView)findViewById(R.id.ferImagememberView);
            image3.setImageBitmap(pc3);
        }
}
}
