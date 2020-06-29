package com.example.progressbar;

import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SegmentedProgressBar bar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.progressBar);
//        bar.setBarSections(10); : to set the number of segments
//        bar.setProgress(); : to increase the progress by 1
//        bar.setProgress(2); : to set the progress by a number
//        bar.setBackgroundColor(ColorCode); : set Background segment's color
//        bar.setProgressColor(ColorCode); : set foreground segment's color

    }
}