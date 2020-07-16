package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class coach extends AppCompatActivity {

    GridView coachGrid;
    TextView tvTrainNo;
    MenuItem item;
    String[] coachNum={"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10"};
    int[] imageNum={R.drawable.one, R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);

        coachGrid=findViewById(R.id.coach_grid);
        item=findViewById(R.id.logout);

        coachAdapter adapter=new coachAdapter(coach.this,coachNum,imageNum);
        coachGrid.setAdapter(adapter);

        tvTrainNo = (TextView) findViewById(R.id.txtTrain);
        final Intent intent= getIntent();
        final String Train_No = intent.getStringExtra("Train_No");
        tvTrainNo.setText(Train_No);


        coachGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(coach.this,List_Pessanger.class);
                intent.putExtra("Train_No",Train_No);
                intent.putExtra("coach",coachNum[+position]);
/*                intent.putExtra("TrainNo", trainNo);*/
                /*intent.putExtra("Date",date);*/
                startActivity(intent);
                /*Toast.makeText(getApplicationContext(), "You Clicked "+coachNum[+position], Toast.LENGTH_SHORT).show();*/
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return super.onCreateOptionsMenu(menu);
        //Intent i = new Intent(Login_Activity.this,MainActivity.class);
        //startActivity(i);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id==R.id.logout)
        {
            Intent i = new Intent(coach.this,MainActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
