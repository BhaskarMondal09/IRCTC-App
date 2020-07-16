package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {

    EditText txtPass,txtUser;
    TextView trainNo;
    Button btnLogin;
    CheckBox chkPass;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        txtUser=(EditText)findViewById(R.id.txtUsername);
        chkPass=(CheckBox)findViewById(R.id.chkShowPassword);
        txtPass=(EditText)findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        trainNo=(TextView)findViewById(R.id.trainNo);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

        chkPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    // show password
                    //txtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    txtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    txtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });


        final Intent intent = getIntent();
        final String str = intent.getStringExtra("message");
        trainNo.setText(str);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkNo=0;
                checkNo = Integer.parseInt(trainNo.getText().toString());
                if(txtUser.getText().toString().equalsIgnoreCase("chirag") && txtPass.getText().toString().equalsIgnoreCase("chirag123")) {

                    if(checkNo==12905)
                    {
                        Intent i = new Intent(Login_Activity.this,coach.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "This Train is not allocated to you", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Login_Activity.this,MainActivity.class);
                        startActivity(i);
                    }
                }
                else if (txtUser.getText().toString().equalsIgnoreCase("bhaskar") && txtPass.getText().toString().equalsIgnoreCase("bhaskar123")){
                    if(checkNo==12905)
                    {
                        Intent i = new Intent(Login_Activity.this,coach.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "This Train is not allocated to you", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Login_Activity.this,MainActivity.class);
                        startActivity(i);
                    }
                }
                else if (txtUser.getText().toString().equalsIgnoreCase("balvant") && txtPass.getText().toString().equalsIgnoreCase("balvant123")){
                    if(checkNo==12905)
                    {
                        String Train_No= intent.getStringExtra("message");
                        Intent i = new Intent(Login_Activity.this,coach.class);
                        i.putExtra("Train_No",Train_No);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "This Train is not allocated to you", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Login_Activity.this,MainActivity.class);
                        startActivity(i);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid User and Password", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

   /* private void userLogin(){
        final String username = txtUser.getText().toString().trim();
        final String password = txtPass.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj=new JSONObject(response);
                            if (!obj.getBoolean("error")){
                                SharedManager.getInstance(getApplicationContext())
                                        .userLogin(
                                                obj.getInt("id"),
                                                obj.getString("UserName")
                                        );

                                startActivity(new Intent(getApplicationContext(),Demo_Activity.class));
                                finish();
                            }else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("UserName",username);
                params.put("Password",password);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }*/

  /*  @Override
    public void onClick(View view) {
        if (view==btnLogin){
            userLogin();
        }
    }*/
}
