package com.example.lenovo.retrikler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.lang.annotation.Annotation;

public class SplashActivity extends AppCompatActivity {
    private int sl=4;
    private TextView q,w,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        logo lg=new logo();
        lg.start();

        q=findViewById(R.id.textView13);
        w=findViewById(R.id.textView14);
        e=findViewById(R.id.textView15);

        Animation UD= AnimationUtils.loadAnimation(this,R.anim.r);
        Animation U= AnimationUtils.loadAnimation(this,R.anim.etrikle);
        q.setAnimation(UD);
        e.setAnimation(UD);
        w.setAnimation(U);

    }
    private class logo extends Thread{
        public void run(){
            try{
                sleep(1000*sl);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }
    }
}
