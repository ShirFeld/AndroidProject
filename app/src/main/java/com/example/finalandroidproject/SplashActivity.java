package com.example.finalandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

//
//    ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(
//            2, 5, 5, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
//
//
//
    private Animation logoAnim;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoImage = findViewById(R.id.imageView);

        logoAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_anim);

        logoImage.startAnimation(logoAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }


}