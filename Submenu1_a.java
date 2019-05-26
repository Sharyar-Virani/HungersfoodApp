package com.example.foodhungers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Submenu1_a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu1_a);
    }

    public void btn_back (View view) {

        startActivity(new Intent(getApplicationContext(),Menu1.class));
    }



}
