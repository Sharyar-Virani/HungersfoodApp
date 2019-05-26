package com.example.foodhungers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Dashboard extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Menu");
    }

    public void btn_Img1(View view) {

        startActivity(new Intent(getApplicationContext(),Menu1.class));
    }

}
