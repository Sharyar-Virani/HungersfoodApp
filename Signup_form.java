package com.example.foodhungers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Signup_form extends AppCompatActivity {
    EditText  txt_HungerName,txt_Email, txt_City, txt_Password;
    Button btn_register;

    DatabaseReference databaseReference;
    FirebaseAuth FirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("SignUp");

        txt_HungerName =(EditText) findViewById(R.id.HungerName);
        txt_Email = (EditText) findViewById(R.id.email);
        txt_City =(EditText)findViewById(R.id.city);
        txt_Password = (EditText)findViewById(R.id.password);
        btn_register = (Button)findViewById(R.id.Signup_Button);


       databaseReference = FirebaseDatabase.getInstance().getReference("Users");
       FirebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String HungerName = txt_HungerName.getText().toString();
                final String Email = txt_Email.getText().toString();
                final String City = txt_City.getText().toString();
                final String Password = txt_Password.getText().toString();



                if (TextUtils.isEmpty(HungerName))
                {
                    Toast.makeText(Signup_form.this, "Please Enter Your Name", Toast.LENGTH_SHORT);
                    return;
                }


                if (TextUtils.isEmpty(Email))
                {
                    Toast.makeText(Signup_form.this, "Please Enter Email", Toast.LENGTH_SHORT);
                    return;
                }


                if (TextUtils.isEmpty(City))
                {
                    Toast.makeText(Signup_form.this, "Please Enter City", Toast.LENGTH_SHORT);
                    return;
                }


                if (TextUtils.isEmpty(Password))
                {
                    Toast.makeText(Signup_form.this, "Please Enter Password", Toast.LENGTH_SHORT);
                    return;
                }


                if (Password.length()<6){

                    Toast.makeText(Signup_form.this, "Password too Short", Toast.LENGTH_SHORT).show();
                }

                    FirebaseAuth.createUserWithEmailAndPassword(Email, Password)
                            .addOnCompleteListener(Signup_form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {



                                    if (task.isSuccessful()) {

                                    Users information  = new Users(

                                            HungerName,
                                            Email,
                                            City

                                    );


                                    FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(Signup_form.this,"Registration Complete",Toast.LENGTH_SHORT);
                                            startActivity(new Intent(getApplicationContext(),Login_Form.class));
                                        }
                                    });



                                    } else {

                                        Toast.makeText(Signup_form.this,"Authentication Failed",Toast.LENGTH_SHORT);

                                    }


                                }
                            });

                }
        });
    }
}