package kr.co.hwakjjin.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static androidx.core.content.ContextCompat.startActivity;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}

