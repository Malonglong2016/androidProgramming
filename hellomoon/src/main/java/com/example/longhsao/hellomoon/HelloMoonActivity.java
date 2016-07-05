package com.example.longhsao.hellomoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HelloMoonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log", "---HelloMoonActivity--------onStart--------------->");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log", "---HelloMoonActivity--------onResume--------------->");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log", "---HelloMoonActivity--------onPause--------------->");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log", "---HelloMoonActivity--------onStop--------------->");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Log", "---HelloMoonActivity--------onDestroy--------------->");
    }
}
