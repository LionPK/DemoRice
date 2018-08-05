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

import com.crud.jo.demorice.adapter.Weed_Member_Adapter;
import com.crud.jo.demorice.model.Weed;
import com.crud.jo.demorice.model.Analysis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class analysis_show extends AppCompatActivity {
    private String TAG = analysis_show.class.getSimpleName();

    private ProgressDialog pDialog;
    private RecyclerView lv;

    // URL to get contacts JSON
    private static String url = "http://www.projectricearea.com/android_view_api/analysis_show.php";

    ArrayList<Analysis> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weed_member_main);
        contactList = new ArrayList<>();
        lv = findViewById(R.id.memberlist);
        new analysis_show.GetContacts().execute();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_backweed) ;
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
            pDialog = new ProgressDialog(WeedMember_list.this);
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

                        String id_weed = c.getString("id_weed");
                        String name_weed = c.getString("name_weed");
                        String type_weed = c.getString("type_weed");
                        String detail_weed = c.getString("detail_weed");
                        String img_weed = c.getString("img_weed");
                        contactList.add(new Weed(id_weed,name_weed,type_weed,detail_weed,img_weed));
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
            Weed_Member_Adapter weed_Member_Adapter = new Weed_Member_Adapter(WeedMember_list.this,contactList);
            lv.setAdapter(weed_Member_Adapter);
            lv.setLayoutManager(new LinearLayoutManager(WeedMember_list.this,LinearLayoutManager.VERTICAL,false));
        }

    }
}





}
