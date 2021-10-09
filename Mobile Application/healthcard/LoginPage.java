package com.example.healthcard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity implements View.OnClickListener{

    Context context;
    String text;

    private TextView register,forgetPassword;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;
    private FirebaseAuth mauth1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        register=(TextView) findViewById(R.id.registertext);
        register.setOnClickListener(this);

        signIn=(Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editTextEmail=(EditText) findViewById(R.id.loginEmail);
        editTextPassword=(EditText) findViewById(R.id.loginPassword);

        mauth1= FirebaseAuth.getInstance();

        forgetPassword =(TextView) findViewById(R.id.textForgetPwd);
        forgetPassword.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registertext:
                Intent intent=new Intent(getApplicationContext(),RegisterUser.class);
                startActivity(intent);
                break;

            case R.id.signIn:
                userLogin();
                break;

            case R.id.textForgetPwd:
                Intent intentSETPWD1=new Intent(getApplicationContext(),forgetpwd.class);
                startActivity(intentSETPWD1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    private void userLogin(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();


        if(email.isEmpty()){
            editTextEmail.setError("Email is required..!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }


        if(password.length()<6){
            editTextPassword.setError("Min password length should be 6 characters..!");
            editTextPassword.requestFocus();
            return;
        }

        mauth1.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()) {
                        //redirect to profile
                        Intent intentp = new Intent(getApplicationContext(),dashboard.class);
                        startActivity(intentp);
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(LoginPage.this, text= "Check your email to verify your account!", Toast.LENGTH_LONG).show();
                    }
                }else{

                    Toast.makeText(LoginPage.this, text= "Failed to login! Please check your credentials!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}