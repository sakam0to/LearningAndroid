package com.zhujingjie.orientations;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OritentationActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Log.d("StateInfo", "onCreate");

        //retrieve information saved by onRetainNonConfigurationInstance()
        Map savedMap = (Map) getLastNonConfigurationInstance();
        if(null != savedMap){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date now = new Date();
            Date saved = (Date) savedMap.get("datetime");
            Log.d("StateInfo","now is "+now.toString()+"\nsaved Time:"+saved.toString());
        }
    }

    @Override
    public void onStart() {
        Log.d("StateInfo", "onStart");
        super.onStart();

        //get Orientation
        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();
        if (d.getWidth() > d.getHeight()) {
            Log.d("StateInfo", "Landscape");
        } else {
            Log.d("StateInfo", "Portrait");
        }

        //change orientation forcibly
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onResume(){
        Log.d("StateInfo", "onResume");
        super.onResume();
    }

    @Override
    public void onPause(){
        Log.d("StateInfo", "onPause");
        super.onPause();
    }

    @Override
    public void onStop(){
        Log.d("StateInfo", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.d("StateInfo", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onRestart(){
        Log.d("StateInfo", "onRestart");
        super.onRestart();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstance){
        //--save whatever you need to persist
        savedInstance.putInt("ID",123456);
        savedInstance.putString("Name","Android Lee");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstance){
        super.onRestoreInstanceState(savedInstance);
        //--retrieve the saved information
        Integer id = savedInstance.getInt("ID");
        String name = savedInstance.getString("Name");
        Log.d("StateInfo", "My name is "+name+". My ID is"+id);
    }

    @Override
    public Object onRetainNonConfigurationInstance(){
        //--save whatever into an object
        Map savedMap = new LinkedHashMap();
        savedMap.put("datetime", new Date());
        return savedMap;
    }

}
