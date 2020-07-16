package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText Text,txtTrain;
    Button btnTrain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text=(EditText)findViewById(R.id.txtDate);
        txtTrain=(EditText)findViewById(R.id.txtTrainNo);
        btnTrain=(Button)findViewById(R.id.btnProcced);

        Date date = new Date();  // to get the date
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // getting date in this format
        String formattedDate = df.format(date.getTime());
        Text.setText(formattedDate);

        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtTrain.length()<5)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Train Number",Toast.LENGTH_SHORT).show();

                    //Intent intent = new Intent();
                    //
                }
                else {
                    String str = txtTrain.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    intent.putExtra("message", str);

                    startActivity(intent);
                }
            }
        });
    }



}
