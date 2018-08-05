package com.crud.jo.demorice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.crud.jo.demorice.adapter.AnalysisAdapter;
import com.crud.jo.demorice.model.Analysis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnalysisArea extends AppCompatActivity {

    private String TAG = Main.class.getSimpleName();
    private ProgressDialog pDialog;
    private RecyclerView lv;




    // URL to get contacts JSON
    private static String url = "http://www.projectricearea.com/android_view_api/analysis_show.php";
    ArrayList<Analysis> contactList;


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
            private class GetContacts extends AsyncTask<Void, Void, Void> {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    // Showing progress dialog
                    pDialog = new ProgressDialog(AnalysisArea.this);
                    pDialog.setMessage("Please wait...");
                    pDialog.setCancelable(false);
                    pDialog.show();

                }

                @Override
                protected Void doInBackground(Void... arg0) {
                    HttpHandler sh = new HttpHandler();

                    // Making a request to url and getting response
                    String jsonStr = sh.makeServiceCall(url);

                    Log.d(TAG, "Response from url: " + jsonStr);

                    if (jsonStr != null) {
                        try {

                            JSONArray mJsonArray = new JSONArray(jsonStr);

                            // looping through All Contacts
                            for (int i = 0; i < mJsonArray.length(); i++) {
                                JSONObject c = mJsonArray.getJSONObject(i);

                                String analy1_id = c.getString("analy1_id");
                                String rice = c.getString("rice");
                                String rice_type = c.getString("rice_type");
                                String weather_napee = c.getString("weather_napee");
                                String weather_napung = c.getString("weather_napung");
                                String district = c.getString("district");
                                String tambon = c.getString("tambon");
                                String rice_area = c.getString("rice_area");
                                String water_area = c.getString("water_area");
                                String chemical_fertilizer = c.getString("chemical_fertilizer");
                                String bio_fertilizer = c.getString("bio_fertilizer");
                                String soil_type = c.getString("soil_type");
                                String adjust_soil = c.getString("adjust_soil");
                                String weed_type = c.getString("weed_type");
                                String weed_Removal = c.getString("weed_Removal");
                                String dayrice_napee = c.getString("dayrice_napee");
                                String dayrice_napung = c.getString("dayrice_napung");
                                String ricedisease_name = c.getString("ricedisease_name");
                                String ricedisease_Removal = c.getString("ricedisease_Removal");
                                String rice_method_one = c.getString("rice_method_one");
                                String rice_method_two = c.getString("rice_method_two");
                                String rice_method_three = c.getString("rice_method_three");
                                String rice_img = c.getString("rice_img");
                                String weed_img = c.getString("weed_img");
                                String soil_img = c.getString("soil_img");
                                String fer_img = c.getString("fer_img");

                                // adding contact to contact list
                                contactList.add(new Analysis(analy1_id,rice,rice_type,weather_napee,weather_napung,district,tambon,rice_area,water_area,chemical_fertilizer,bio_fertilizer,soil_type
                                        ,adjust_soil,weed_type,weed_Removal,dayrice_napee,dayrice_napung,ricedisease_name,ricedisease_Removal,rice_method_one,rice_method_two,rice_method_three,
                                        weed_img,rice_img,soil_img,fer_img));


                            }
                        } catch (final JSONException e) {
                            Log.e(TAG, "Json parsing error: " + e.getMessage());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Json parsing error: " + e.getMessage(),
                                            Toast.LENGTH_LONG)
                                            .show();
                                }
                            });

                        }
                    } else {
                        Log.e(TAG, "Couldn't get json from server.");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),
                                        "Couldn't get json from server. Check LogCat for possible errors!",
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });

                    }

                    return null;
                }

                @Override
                protected void onPostExecute(Void result) {
                    super.onPostExecute(result);
                    // Dismiss the progress dialog
                    if (pDialog.isShowing())
                        pDialog.dismiss();
                    /**
                     * Updating parsed JSON data into ListView
                     * */

                    AnalysisAdapter analysisAdapter = new AnalysisAdapter(AnalysisArea.this,contactList);
                    lv.setAdapter(analysisAdapter);
                    lv.setLayoutManager(new LinearLayoutManager(AnalysisArea.this,LinearLayoutManager.VERTICAL,false));
                }

            }

        }