package com.example.lenovo.retrikler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText fname,pass,email;
    private Button but;
    private FirebaseAuth fb;
    private ProgressDialog pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fb=FirebaseAuth.getInstance();

        pb=new ProgressDialog(this);

        fname = findViewById(R.id.editText3);
        pass = findViewById(R.id.editText4);
        email = findViewById(R.id.editText5);
        but= findViewById(R.id.button2);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate());
                String useremail=email.getText().toString().trim();
                String userpass=pass.getText().toString().trim();
                fb.createUserWithEmailAndPassword(useremail, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    private boolean validate() {
        Boolean result;
        result = false;

        String namee = fname.getText().toString();
        String password = pass.getText().toString();
        String eemail = email.getText().toString();

        if (namee.isEmpty() ||  password.isEmpty() || eemail.isEmpty()) {
            Toast.makeText(this, "Please Enter All Details", Toast.LENGTH_LONG).show();
        } else {
            result = true;
        }
        return result;
    }
}

