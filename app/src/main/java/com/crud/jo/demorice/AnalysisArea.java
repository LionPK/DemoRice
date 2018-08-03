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



            Spinner mySpinner = (Spinner) findViewById(R.id.spinnerrice);

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AnalysisArea.this,
                    android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.spinnerrice));

            myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mySpinner.setAdapter(myAdapter);

            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_backsoil) ;
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),
                            Users_Main.class);
                    startActivity(i);
                    finish();

        }
    }
    }
}
