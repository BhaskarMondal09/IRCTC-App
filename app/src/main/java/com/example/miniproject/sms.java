package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms extends AppCompatActivity {
    final int SEND_SMS_PERMISSION_REQUEST_CODE=1;
    Button send;
    EditText number;
    EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        send=findViewById(R.id.btnsend);
        send.setEnabled(false);
        if (checkPermission((Manifest.permission.SEND_SMS)))
        {
            send.setEnabled(true);
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
        }
    }

    public void onSend(View view) {
        String phoneNumber= number.getText().toString();
        String smsMessage=message.getText().toString();
        if (phoneNumber==null||phoneNumber.length()==0||smsMessage==null||smsMessage.length()==0)
        {return;}
        if(checkPermission((Manifest.permission.SEND_SMS)))
        {
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,smsMessage,null ,null );
            Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean checkPermission(String permission)
    {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check== PackageManager.PERMISSION_GRANTED);
    }
}
