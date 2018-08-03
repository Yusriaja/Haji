package com.example.manasatpc.haji;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button btLogin, btRegister;
    EditText et_first_name, et_last_name, et_password, et_email,
     et_phone, et_squance;

    RadioButton rb_user, rb_admin;

    private DPHelper dpHelper;
    String finalUrl ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dpHelper = new DPHelper(this);

        defineVariables();
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();

            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginAcivity = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(loginAcivity);
            }
        });

    }
    public void defineVariables(){
        btLogin = (Button)findViewById(R.id.bt_login);
        btRegister = (Button)findViewById(R.id.bt_register);
        et_first_name = (EditText)findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        et_password = (EditText)findViewById(R.id.et_password);
        et_email = (EditText)findViewById(R.id.et_email);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_squance = (EditText)findViewById(R.id.et_id_sequance);
         }
    public void saveUser(){
        String first_name =et_first_name.getText().toString().trim();
        String last_name = et_last_name.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String email = et_email.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();
        String squance = et_squance.getText().toString().trim();
        String admin_user = "0";

        //  String user_admin = rb
        if (first_name.isEmpty() ||last_name.isEmpty() || password.isEmpty() || email.isEmpty()
                || phone.isEmpty() || squance.isEmpty()){
            Toast.makeText(getApplicationContext(),getString(R.string.empty),Toast.LENGTH_LONG).show();
            return;
        }

         String url = "https://aeny.000webhostapp.com/adduser.php";
         String id_haji_PHP = "?id_haji=";
        String first_name_PHP = "&first_name=";
        String last_name_PHP = "&last_name=";
        String email_PHP = "&email=";
        String phone_PHP = "&phone=";
        String user_admin_PHP = "&user_admin=";
        String password_PHP = "&password=";

        try {
             finalUrl =   url + id_haji_PHP + URLEncoder.encode(squance,"UTF-8")+ first_name_PHP +
                    URLEncoder.encode(first_name,"UTF-8") + last_name_PHP + URLEncoder.encode(last_name,"UTF-8")+
                    email_PHP + URLEncoder.encode(email,"UTF-8")+ phone_PHP +URLEncoder.encode(phone,"UTF-8")+
                     user_admin_PHP + URLEncoder.encode(admin_user,"UTF-8")+password_PHP + URLEncoder.encode(password,"UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                URL insertUser = null;
                try {
                    insertUser = new URL(finalUrl);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                HttpURLConnection insertConnection= null;
                try {
                    insertConnection = (HttpURLConnection)insertUser.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    InputStreamReader reader = new InputStreamReader(insertConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    final String result = bufferedReader.readLine();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                            et_first_name.setText("");
                            et_last_name.setText("");
                            et_password.setText("");
                            et_squance.setText("");
                            et_phone.setText("");
                            et_email.setText("");

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

       }




}
