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
import android.widget.Toast;
import com.crud.jo.demorice.adapter.SoilAdapter;
import com.crud.jo.demorice.model.Soil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class soil_list extends AppCompatActivity {

    private String TAG = soil_list.class.getSimpleName();

    private ProgressDialog pDialog;
    private RecyclerView lv;

    // URL to get contacts JSON
    private static String url = "http://www.projectricearea.com/android_view_api/soil_list.php";

    ArrayList<Soil> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soil_main);

        contactList = new ArrayList<>();
        lv = findViewById(R.id.list);
        new soil_list.GetContacts().execute();


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_back) ;
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }



    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(soil_list.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }



        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
//                    JSONArray contacts = jsonObj.getJSONArray(0);

                    JSONArray mJsonArray = new JSONArray(jsonStr);
//                    JSONObject mJsonObject = mJsonArray.getJSONObject(0);

                    // looping through All Contacts
                    for (int i = 0; i < mJsonArray.length(); i++) {
                        JSONObject c = mJsonArray.getJSONObject(i);

                        String id_soil = c.getString("id_soil");
                        String type_soil = c.getString("type_soil");
                        String detail_soil = c.getString("detail_soil");
                        String img_soil = c.getString("img_soil");
                        contactList.add(new Soil(id_soil,type_soil,detail_soil,img_soil));
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
                                Toast.LENGTH_LONG).show();
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
        SoilAdapter soilAdapter = new SoilAdapter(soil_list.this,contactList);
        lv.setAdapter(soilAdapter);
        lv.setLayoutManager(new LinearLayoutManager(soil_list.this,LinearLayoutManager.VERTICAL,false));
    }
}
}