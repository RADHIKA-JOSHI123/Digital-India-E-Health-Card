package com.example.healthcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    Context context;
    String text;
    private FirebaseAuth mAuth;
    private TextView  banner, registerUser;
    private EditText editTextFullName, editTextage, editTextEmail, editTextPassword;
    //private ProgressBar rprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser=(Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextFullName=(EditText) findViewById(R.id.fullName);
        editTextage=(EditText) findViewById(R.id.age);
        editTextEmail=(EditText) findViewById(R.id.email);
        editTextPassword=(EditText) findViewById(R.id.password);

        //progressBar=(progressBar) findViewById(R.id.rprogressbar);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                Intent intennt=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intennt);
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }

    }

    private void registerUser() {

        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        String fullName=editTextFullName.getText().toString().trim();
        String age=editTextage.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextFullName.setError("Full Name is required!");
            editTextFullName.requestFocus();
            return;
        }

        if(age.isEmpty()){
            editTextage.setError("Age is required!");
            editTextage.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide Valid Email");
            editTextEmail.requestFocus();
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Min password length should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){

                        if(task.isSuccessful()){
                            User user = new User(fullName,age,email);

                            String path;
                            FirebaseDatabase.getInstance().getReference(path= "Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>(){

                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){

                                        Toast.makeText(context= RegisterUser.this,text= "User has been registered successfully!", Toast.LENGTH_LONG).show();

                                        //redirect to login
                                    }else{
                                        Toast.makeText(RegisterUser.this, text= " Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        }else{
                            Toast.makeText(RegisterUser.this, text= " Failed to register! Try again!", Toast.LENGTH_LONG).show();
                        }
                    }

                });
    }
}


