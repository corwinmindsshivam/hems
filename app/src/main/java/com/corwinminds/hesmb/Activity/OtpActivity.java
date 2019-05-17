package com.corwinminds.hesmb.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.corwinminds.hesmb.Handler.RequestHandler;
import com.corwinminds.hesmb.R;
import com.corwinminds.hesmb.URL.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Pattern;

public class OtpActivity extends AppCompatActivity {
    private EditText user_mobile_number,user_otp;
    private Button next,submit;
    private String mobile_number,otp;
    String user_id;
    private static final Pattern MOBILE_PATTERN =
            Pattern.compile("^([789]{1})([0123456789]{1})([0-9]{8})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
         user_id= getIntent().getExtras().getString("user_id");
        user_mobile_number=findViewById(R.id.user_mobile_number);
        next=findViewById(R.id.user_btn_next);
        user_otp=findViewById(R.id.user_otp);
        submit=findViewById(R.id.user_btn_submit_otp);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobileValidate()) {
                    new RegisterMobile().execute();

                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otpValidate())
                {
                    new ConfirmOtp().execute();
                }
            }
        });
    }

    public boolean otpValidate() {
        otp=user_otp.getText().toString().trim();

        boolean check = true;
        if (otp.isEmpty()) {
            user_otp.setError("Field can't be empty");
            check = false;
        }

        return check;
    }
    public boolean mobileValidate() {
       mobile_number=user_mobile_number.getText().toString().trim();

        boolean check = true;
         if (mobile_number.isEmpty()) {
            user_mobile_number.setError("Field can't be empty");
            check = false;
        } else if (!MOBILE_PATTERN.matcher(mobile_number).matches()) {
            user_mobile_number.setError("Please enter a valid mobile number");
            check = false;
        }

        return check;
    }
    class RegisterMobile extends AsyncTask<Void, Void, String> {

     //   ProgressBar progressBar;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
       //     progressBar = findViewById(R.id.loginprogressBar);
         //   progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
           // progressBar.setVisibility(View.GONE);
            try{
            JSONObject obj = new JSONObject(s);
                if(obj.get("success").equals(0)){
                    Toast.makeText(OtpActivity.this,"Mobile Number Already Exist",Toast.LENGTH_LONG).show();
                    user_mobile_number.setFocusable(false);
                    next.setVisibility(View.GONE);
                    user_otp.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    new GENRATEOTP().execute();
                } else if(obj.get("success").equals(1)){
                    user_mobile_number.setFocusable(false);
                    next.setVisibility(View.GONE);
                    user_otp.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    new GENRATEOTP().execute();
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
            params.put("user_id",user_id);
            params.put("user_phone",mobile_number);

            //returing the response
            return requestHandler.sendPostRequest(URLs.URL_REGISTERMOBILENUMBER, params);
        }
    }
    class GENRATEOTP extends AsyncTask<Void, Void, String> {

        //   ProgressBar progressBar;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //     progressBar = findViewById(R.id.loginprogressBar);
            //   progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // progressBar.setVisibility(View.GONE);
            try{
                JSONObject obj = new JSONObject(s);
                if(obj.get("success").equals(1)){
                    Toast.makeText(OtpActivity.this,"Otp Send On Your Number",Toast.LENGTH_LONG).show();
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

            params.put("user_phone",mobile_number);

            //returing the response
            return requestHandler.sendPostRequest(URLs.URL_GENRATEOTP, params);
        }
    }

    class ConfirmOtp extends AsyncTask<Void, Void, String> {

        //   ProgressBar progressBar;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //     progressBar = findViewById(R.id.loginprogressBar);
            //   progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // progressBar.setVisibility(View.GONE);
            try{
                JSONObject obj = new JSONObject(s);
                if(obj.get("success").equals(1)){
                    Toast.makeText(OtpActivity.this,obj.getString("msg"),Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(OtpActivity.this,DashboardActivity.class);
                    startActivity(intent);
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

            params.put("user_phone",mobile_number);
            params.put("user_otp",otp);


            //returing the response
            return requestHandler.sendPostRequest(URLs.URL_CONFRIMOTP, params);
        }
    }


}
