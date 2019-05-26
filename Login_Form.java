package com.example.foodhungers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {

    EditText txt_Email, txt_Password;
    Button btn_login;
     private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login");

        txt_Email = (EditText)findViewById(R.id.txt_email);
        txt_Password = (EditText)findViewById(R.id.txt_password);
        btn_login = (Button)findViewById(R.id.btn_login);

       firebaseAuth = firebaseAuth.getInstance();



 btn_login.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {


String email = txt_Email.getText().toString().trim();
String password = txt_Password.getText().toString().trim();

if (TextUtils.isEmpty(email))
{
Toast.makeText(Login_Form.this, "Please Enter Email", Toast.LENGTH_SHORT);
return;
}

if (TextUtils.isEmpty(password))
{
Toast.makeText(Login_Form.this, "Please Enter Password", Toast.LENGTH_SHORT);
return;
}

if (password.length()<6){

Toast.makeText(Login_Form.this, "Password too Short", Toast.LENGTH_SHORT).show();
}


firebaseAuth.signInWithEmailAndPassword(email, password)
.addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
if (task.isSuccessful()) {

startActivity(new Intent(getApplicationContext(),Dashboard.class));

} else {

Toast.makeText(Login_Form.this,"Login Failed",Toast.LENGTH_SHORT);


}

// ...
}
});

}
});

    }

    public void btn_signupForm(View view) {

        startActivity(new Intent(getApplicationContext(),Signup_form.class));
    }


}
