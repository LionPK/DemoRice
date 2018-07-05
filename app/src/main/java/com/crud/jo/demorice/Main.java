package com.crud.jo.demorice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


import java.util.ArrayList;
import java.util.HashMap;

public class Main extends AppCompatActivity {

    private String TAG = Main.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
//    private Button btnlinktoolbar_back;




    // URL to get contacts JSON
    private static String url = "http://www.projectricearea.com/android_view_api/rice_list.php";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        contactList = new ArrayList<>();
//        btnlinktoolbar_back = (Button) findViewById(R.id.toolbar_back);

        lv = (ListView) findViewById(R.id.list);
        new GetContacts().execute();

    }
    //link to Sign In
//        btnlinktoolbar_back.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View view) {
//            Intent i = new Intent(Main.this,
//                    Users_Main.class);
//            startActivity(i);
//            finish();
//        }
//    });

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Main.this);
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

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("rice_img", rice_img);
                        contact.put("id_rice", id_rice);
                        contact.put("name_rice", name_rice);
                        contact.put("type_rice", type_rice);
                        contact.put("detail_rice", detail_rice);

                        // adding contact to contact list
                        contactList.add(contact);
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
            ListAdapter adapter = new SimpleAdapter(
                    Main.this, contactList,
                    R.layout.list_item, new String[]{"name_rice", "type_rice",
                    "detail_rice" , "rice_img"}, new int[]{R.id.name,
                    R.id.type, R.id.detail});

            lv.setAdapter(adapter);
        }

    }

}
