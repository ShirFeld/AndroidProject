package com.example.finalandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity5 extends AppCompatActivity {
    VideoView video1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        video1 = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() +"/" +R.raw.video1;
        Uri uri = Uri.parse(videoPath);
        video1.setVideoURI(uri);


        // Button to stop and continue the video
        MediaController mediaController = new MediaController(this);
        video1.setMediaController(mediaController);
        mediaController.setAnchorView(video1);

    }
}