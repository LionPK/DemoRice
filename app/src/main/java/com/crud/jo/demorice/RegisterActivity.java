package com.crud.jo.demorice;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.crud.jo.demorice.app.AppConfig;
import com.crud.jo.demorice.app.AppController;
import com.crud.jo.demorice.helper.SQLiteHandler;
import com.crud.jo.demorice.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btnRegister;
//    private Button btnLinkToLogin;
    private EditText inputFullName;
    private EditText inputFirstName;
    private EditText inputLastName;
    private Spinner inputSex;
    private EditText inputWork;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputRePassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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

        inputFullName = (EditText) findViewById(R.id.user_edit_text);
        inputFirstName = (EditText) findViewById(R.id.first_edit_text);
        inputLastName = (EditText) findViewById(R.id.last_edit_text);
        inputSex = (Spinner) findViewById(R.id.sex_edit_text);
        inputWork = (EditText) findViewById(R.id.career_edit_text);
        inputEmail = (EditText) findViewById(R.id.email_edit_text);
        inputPassword = (EditText) findViewById(R.id.password_edit_text);
        inputRePassword = (EditText) findViewById(R.id.confirm_password_edit_text);
        btnRegister = (Button) findViewById(R.id.exit_button);
//        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.sex_edit_text));

        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        inputSex.setAdapter(myAdapter);
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(RegisterActivity.this,
                    LoginActivity.class);
            startActivity(intent);
            finish();
        }

        // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputFullName.getText().toString().trim();
                String first_name = inputFirstName.getText().toString().trim();
                String last_name = inputLastName.getText().toString().trim();
                String sex = inputSex.getSelectedItem().toString().trim();
                String work = inputWork.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String re_password = inputRePassword.getText().toString().trim();

                final TextInputLayout nError = findViewById(R.id.user_text_input);
                final TextInputLayout fError = findViewById(R.id.first_text_input);
                final TextInputLayout lError = findViewById(R.id.last_text_input);
                final TextInputLayout sError = findViewById(R.id.sex_text_input);
                final TextInputLayout wError = findViewById(R.id.career_text_input);
                final TextInputLayout eError = findViewById(R.id.email_text_input);
                final TextInputLayout pError = findViewById(R.id.password_text_input);
                final TextInputLayout reError = findViewById(R.id.confirm_password_text_input);

                nError.setError(null);
                fError.setError(null);
                lError.setError(null);
                sError.setError(null);
                wError.setError(null);
                eError.setError(null);
                pError.setError(null);
                reError.setError(null);


                String emailPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                        "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                        "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]" +
                        "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                        "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";


                if (name.isEmpty() && first_name.isEmpty() && last_name.isEmpty() && sex.isEmpty() && work.isEmpty() && email.isEmpty() && password.isEmpty() && re_password.isEmpty()) {
                    nError.setError(getString(R.string.rice_error_not_enter_name));
                    fError.setError(getString(R.string.rice_error_not_enter_first));
                    lError.setError(getString(R.string.rice_error_not_enter_last));
                    sError.setError(getString(R.string.rice_error_not_enter_sex));
                    wError.setError(getString(R.string.rice_error_not_enter_work));
                    eError.setError(getString(R.string.rice_error_not_enter_email));
                    pError.setError(getString(R.string.rice_error_not_enter_pass));
                    reError.setError(getString(R.string.rice_error_not_enter_re_pass));

                }else if (!name.isEmpty() && !first_name.isEmpty() && !last_name.isEmpty() && !sex.isEmpty() && !work.isEmpty() && (!email.isEmpty() && !email.matches(emailPattern)) && !password.isEmpty() && !re_password.isEmpty()) {
                    eError.setError(getString(R.string.rice_error_not_match_email));

                }else if (!name.isEmpty() && !first_name.isEmpty() && !last_name.isEmpty() && !sex.isEmpty() && !work.isEmpty() && (!email.isEmpty() && email.matches(emailPattern)) && (!password.isEmpty() && password.length() < 8) && (!re_password.isEmpty() && password.equals(re_password))) {
                    pError.setError(getString(R.string.rice_error_password_less));
                    reError.setError(getString(R.string.rice_error_password_less));

                }else if (!name.isEmpty() && !first_name.isEmpty() && !last_name.isEmpty() && !sex.isEmpty() && !work.isEmpty() && (!email.isEmpty() && email.matches(emailPattern)) && (!password.isEmpty() && password.length() >= 8) && (!re_password.isEmpty() && !password.equals(re_password))) {
                    reError.setError(getString(R.string.rice_error_not_enter_re_pass_notmatch));

                }else if (!name.isEmpty() && !first_name.isEmpty() && !last_name.isEmpty() && !sex.isEmpty() && !work.isEmpty() && (!email.isEmpty() && email.matches(emailPattern)) && (!password.isEmpty() && password.length() >= 8) && (!re_password.isEmpty() && password.equals(re_password))) {
                    registerUser(name, first_name, last_name, sex, work, email, password);

                }
//                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
//                    registerUser(name, email, password);
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "Please enter your details!", Toast.LENGTH_LONG)
//                            .show();
//                }
            }
        });

        // Link to Login Screen
//        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),
//                        LoginActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });
    }

    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     * */
    private void registerUser(final String name,final String first_name, final String last_name, final String sex, final String work, final String email,
                              final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String first_name = user.getString("first_name");
                        String last_name = user.getString("last_name");
                        String sex = user.getString("sex");
                        String work = user.getString("work");
                        String email = user.getString("email");
                        String created_at = user.getString("created_at");

                        // Inserting row in users table
                        db.addUser(name, first_name, last_name, sex, work, email, uid, created_at);

                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                RegisterActivity.this,
                                LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("first_name", first_name);
                params.put("last_name", last_name);
                params.put("sex", sex);
                params.put("work", work);
                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
