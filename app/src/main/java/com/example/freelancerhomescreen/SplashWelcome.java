package com.example.freelancerhomescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.core.splashscreen.SplashScreen;
public class SplashWelcome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*handle the splash screen transition just before calling super.onCreate()*/
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*to keep the splash screen*/
    }
}