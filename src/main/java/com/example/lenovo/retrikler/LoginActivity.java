package com.example.lenovo.retrikler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button Butt;
    private TextView info;
    private FirebaseAuth fbb;
    private FirebaseAuth.AuthStateListener mauth;
    private ProgressDialog pb;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email =  findViewById(R.id.editText2);
        pass =  findViewById(R.id.editText);
        info = findViewById(R.id.textView);
        Butt =  findViewById(R.id.button);
        relativeLayout=findViewById(R.id.loginlayout);

        fbb=FirebaseAuth.getInstance();
        FirebaseUser user=fbb.getCurrentUser();


        pb=new ProgressDialog(this);

        if (user!=null)
        {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }


        Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.show();
                pb.setMessage("Please Wait...");
                String uemail= email.getText().toString();
                String upass=pass.getText().toString();
                fbb.signInWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            pb.dismiss();
                            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        }
                        else {
                            pb.dismiss();
                            Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                            Snackbar.make(relativeLayout,"Username 0r Password may be incorrect  \n Data may be off",Snackbar.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });


    }



}

