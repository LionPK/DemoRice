package com.crud.jo.demorice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AlertDialog.Builder;

public class RegisterActivity extends AppCompatActivity {
    private Button button_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        button_exit = (Button) findViewById(R.id.exit_button);
//
//        button_exit.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),
//                        LoginActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

}
