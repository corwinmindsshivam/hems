package com.corwinminds.hesmb.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.corwinminds.hesmb.Handler.RequestHandler;
import com.corwinminds.hesmb.Model.User;
import com.corwinminds.hesmb.R;

import com.corwinminds.hesmb.URL.URLs;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private EditText user_id_EditText,user_password_EditText;
    private Button user_login_Button;
    private TextView user_forgot_password_Textview;
    private  String user_id_String,user_password_String,user_id;
    SharedPreferences sp;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

sp= getSharedPreferences("hems",MODE_PRIVATE);
        if(sp.getBoolean("hems",false)){
            Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(intent);

        }
        user_id_EditText=findViewById(R.id.user_id);
        user_password_EditText=findViewById(R.id.user_password);

        user_forgot_password_Textview=findViewById(R.id.user_forgot_password);
        user_login_Button=findViewById(R.id.user_btn_sign_in);
        user_login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    new Login().execute();
                }




                                }

        });
        user_forgot_password_Textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });



    }
    public boolean validate() {
        user_id_String = user_id_EditText.getText().toString().trim();
        user_password_String = user_password_EditText.getText().toString().trim();

        boolean check = true;
        if (user_id_String.isEmpty()) {
            user_id_EditText.setError("Field can't be empty");
            check = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(user_id_String).matches()) {
            user_id_EditText.setError("Please enter a valid email address");
            check = false;
        } else if (user_password_String.isEmpty()) {
            user_password_EditText.setError("Field can't be empty");
            check = false;
        } else if (!PASSWORD_PATTERN.matcher(user_password_String).matches()) {
            user_password_EditText.setError("at least 1 special character,at least 4 characters");
            check = false;
        }

        return check;
    }
    class Login extends AsyncTask<Void, Void, String> {

        ProgressBar progressBar;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = findViewById(R.id.loginprogressBar);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);

            try {
                JSONObject obj = new JSONObject(s);
                JSONObject obj1=obj.getJSONObject("user");
                if(obj.get("success").equals(1)){
                    Toast.makeText(LoginActivity.this,obj.getString("msg"),Toast.LENGTH_SHORT).show();



                    user_id=obj1.getString("user_id");
                    Intent intent=new Intent(LoginActivity.this,OtpActivity.class);
                    intent.putExtra("user_id",user_id);
                    startActivity(intent);
                    sp.edit().putBoolean("hems",true).apply();
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        @Override
        protected String doInBackground(Void... voids) {
            //creating request handler object
            RequestHandler requestHandler = new RequestHandler();

            //creating request parameters
            HashMap<String, String> params = new HashMap<>();
            params.put("user_email", user_id_String);
            params.put("user_password", user_password_String);

            //returing the response
            return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
        }
    }


}
