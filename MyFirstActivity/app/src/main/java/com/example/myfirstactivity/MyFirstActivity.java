package com.example.myfirstactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MyFirstActivity extends Activity {
    String tag = "Lifecycle";

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_first);
        Log.d(tag, "onCreate()");
    }

    public void onStart(){
        super.onStart();
        Log.d(tag, "onStart()");
    }

    public void onResume(){
        super.onResume();
        Log.d(tag, "onResume()");
    }

    public void onPause(){
        super.onPause();
        Log.d(tag, "onPause()");
    }

    public void onStop(){
        super.onStop();
        Log.d(tag, "onStop()");
    }

    public void onRestart(){
        super.onRestart();
        Log.d(tag, "onRestart()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(tag, "onDestroy()");
    }
}
