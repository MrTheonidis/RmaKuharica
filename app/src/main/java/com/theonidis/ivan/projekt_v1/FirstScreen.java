package com.theonidis.ivan.projekt_v1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000; /// 4000 milisekundi je 4 sekunde
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent registerScreen = new Intent(FirstScreen.this, RegisterScreen.class); //Home activity je second activity
                startActivity(registerScreen);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
