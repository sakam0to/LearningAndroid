package com.zhujingjie.usingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent i = new Intent("Second Activity");
        Intent.createChooser(i, "I can customize my pop window....");
        startActivity(i);
    }
}
