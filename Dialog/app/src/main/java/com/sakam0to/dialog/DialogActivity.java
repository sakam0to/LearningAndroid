package com.sakam0to.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends Activity {
    String tag = "Dialog";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Log.d(tag, "onCreate");
    }

    public void onClick(View view){
        Log.d(tag, "onClick");
        showDialog(1);
    }

    public void onClick2(View view){
        Log.d(tag, "onClick2");
        showDialog(2);
    }

    public void onClick3(View view){
        Log.d(tag, "onClick3");
        showDialog(3);
    }

    @Override
    protected Dialog onCreateDialog(int id){

        switch (id) {
            case 1:
                final CharSequence[] items = {"Asuka", "Sakamoto", "Shiraishi"};
                boolean[] itemChecked = new boolean[items.length];
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("This is a pop-up Dialog");
                builder.setPositiveButton("分かりました",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int whichButton) {
                                Toast.makeText(getBaseContext(), "坂本一番です", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.setNegativeButton("いいえ",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int whichButton) {
                                Toast.makeText(getBaseContext(), "ありがとうございます", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.setMultiChoiceItems(items, itemChecked,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                Toast.makeText(getBaseContext(), items[which] + (isChecked ? "checked!" : "unchecked!"), Toast.LENGTH_SHORT).show();
                            }
                        });
                return  builder.create();
            case 2:
                final ProgressDialog dialog = ProgressDialog.show(this, "AKB48 Team A", "Loading...", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            dialog.dismiss();
                        } catch (InterruptedException exception){
                            exception.printStackTrace();
                        }
                    }
                }).start();
                return dialog;
            case 3:
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setTitle("This is a detailed Progress Dialog");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int whichButton) {
                                Toast.makeText(getBaseContext(), "OK Clicked!", Toast.LENGTH_SHORT).show();
                            }
                        });
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
                            }
                        });

                progressDialog.setProgress(0);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 1; i < 20; i++){
                            try{
                                Thread.sleep(1000);
                                progressDialog.incrementProgressBy(5);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        progressDialog.dismiss();
                    }
                }).start();
                return progressDialog;

            default:
                return null;
        }
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
