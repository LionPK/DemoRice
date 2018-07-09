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
import com.crud.jo.demorice.adapter.Rice_Member_Adapter;
import com.crud.jo.demorice.model.Rice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class RiceMember_list extends AppCompatActivity {



    private String TAG = RiceMember_list.class.getSimpleName();

    private ProgressDialog pDialog;
    private RecyclerView lv;

    // URL to get contacts JSON
    private static String url = "http://www.projectricearea.com/android_view_api/fertilizer_list.php";

    ArrayList <Rice> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rice_member_list);

        contactList = new ArrayList<>();
        lv = findViewById(R.id.memberlist);
        new GetContacts().execute();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_back) ;
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
    /**
     * Async task class to get json by making HTTP call
     */
    protected class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(RiceMember_list.this);
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
                        String id_rice = c.getString("id_rice");
                        String name_rice = c.getString("name_rice");
                        String type_rice = c.getString("type_rice");
                        String detail_rice = c.getString("detail_rice");
                        String rice_img = c.getString("rice_img");

                        contactList.add(new Rice(id_rice,name_rice,type_rice,detail_rice,rice_img));
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
            Rice_Member_Adapter rice_Member_Adapter = new Rice_Member_Adapter(RiceMember_list.this,contactList);
            lv.setAdapter(rice_Member_Adapter);
            lv.setLayoutManager(new LinearLayoutManager(RiceMember_list.this,LinearLayoutManager.VERTICAL,false));
        }

    }
}
