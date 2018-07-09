package com.crud.jo.demorice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email_edit_text);
        inputPassword = (EditText) findViewById(R.id.password_edit_text);
        btnLogin = (Button) findViewById(R.id.login_button);
        btnLinkToRegister = (Button) findViewById(R.id.register_button);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_login) ;
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

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginActivity.this, Users_Main.class);
            startActivity(intent);
            finish();
        }

        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
//                if (!email.isEmpty() && !password.isEmpty()) {
//                    // login user
//                    checkLogin(email, password);
//                } else {
//                    // Prompt user to enter credentials
//                    Toast.makeText(getApplicationContext(),
//                            "Please enter the credentials!", Toast.LENGTH_LONG)
//                            .show();
//                }

                String emailPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                        "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
                        "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]" +
                        "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                        "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

                final TextInputLayout eError = findViewById(R.id.email_text_input);
                final TextInputLayout pError = findViewById(R.id.password_text_input);

                eError.setError(null);
                pError.setError(null);

                if (email.isEmpty() && !password.isEmpty()) {
//                    Toast.makeText(getApplicationContext(),"กรุณากรอกข้อมูล!", Toast.LENGTH_LONG).show();
                    eError.setError(getString(R.string.rice_error_not_enter_email));

                }else if ((!email.isEmpty() && !email.matches(emailPattern)) && password.isEmpty()) {
                    eError.setError(getString(R.string.rice_error_not_match_email));
                    pError.setError(getString(R.string.rice_error_not_enter_password));

                }else if (password.isEmpty() && !email.isEmpty()) {
                    pError.setError(getString(R.string.rice_error_not_enter_password));

                }else if ((!password.isEmpty() && password.length() < 8) && email.isEmpty()) {
                    pError.setError(getString(R.string.rice_error_password_less));
                    eError.setError(getString(R.string.rice_error_not_enter_email));

                }else if (email.isEmpty() && password.isEmpty()) {
                    eError.setError(getString(R.string.rice_error_not_enter_email));
                    pError.setError(getString(R.string.rice_error_not_enter_password));

                }else if ((!email.isEmpty() && !email.matches(emailPattern)) && (!password.isEmpty() && password.length() < 8)) {
                    eError.setError(getString(R.string.rice_error_not_match_email));
                    pError.setError(getString(R.string.rice_error_password_less));

                }else if ((!email.isEmpty() && !email.matches(emailPattern)) && (!password.isEmpty() && password.length() >= 8)) {
                    eError.setError(getString(R.string.rice_error_not_match_email));

                }else if ((!email.isEmpty() && email.matches(emailPattern)) && (!password.isEmpty() && password.length() < 8)) {
                    pError.setError(getString(R.string.rice_error_password_less));

                }else if ((!email.isEmpty() && email.matches(emailPattern)) && (!password.isEmpty() && password.length() >= 8)) {
                    // login user
                    checkLogin(email, password);
                }
            }

        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String email, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        session.setLogin(true);

                        // Now store the users in SQLite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String first_name = user.getString("first_name");
                        String last_name = user.getString("last_name");
                        String sex = user.getString("sex");
                        String work = user.getString("work");
                        String email = user.getString("email");
                        String created_at = user.getString("created_at");

                        // Inserting row in user table
                        db.addUser(name, first_name, last_name, sex, work, email, uid, created_at);

                        // Launch main activity
                        Intent intent = new Intent(LoginActivity.this,
                                Users_Main.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
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
