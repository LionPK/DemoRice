package com.crud.jo.demorice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AnalysisArea extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_analysis);
            Spinner mySpinnerrice = (Spinner) findViewById(R.id.spinnerrice);
            Spinner mySpinnerarea = (Spinner) findViewById(R.id.spinnearea);
            Spinner mySpinnertambon = (Spinner) findViewById(R.id.spinnetambon);
            Spinner mySpinnerwater_area = (Spinner) findViewById(R.id.spinnerwater_area);

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AnalysisArea.this,
                    android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinnerrice));

            myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mySpinnerrice.setAdapter(myAdapter);


            ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(AnalysisArea.this,
                    android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinnearea));

            myAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mySpinnerarea.setAdapter(myAdapter2);

            ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(AnalysisArea.this,
                    android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinnetambon));

            myAdapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mySpinnertambon.setAdapter(myAdapter3);

            ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(AnalysisArea.this,
                    android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinnerwater_area));

            myAdapter4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mySpinnerwater_area.setAdapter(myAdapter4);

            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar) ;
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),
                            Users_Main.class);
                    startActivity(i);
                    finish();
                }
            });

    }

    }

