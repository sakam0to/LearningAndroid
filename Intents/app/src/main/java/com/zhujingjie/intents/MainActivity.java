package com.zhujingjie.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickWebBrowser(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com"));
        startActivity(i);
    }

    public void onClickMakeCalls(View view){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+12345678900"));
        startActivity(i);
    }

    public void onClickShowMap(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500, -122.481670"));
        startActivity(i);
    }

    public void onClickLaunchMyBrowser(View view){
        Intent i = new Intent("My Browser");
        i.setData(Uri.parse("http://www.amazon.com"));
        startActivity(i);
    }
}
