package com.deeppsy.psychologyfacts;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;

    public static String SWITCH3 = "switch3";

    private static final String job_tag = "Notification";

    @RequiresApi(api = Build.VERSION_CODES.P)
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main);
        /*AudienceNetworkAds.initialize(this);*/
        All_facts_together.b = 1;
        FirebaseMessaging.getInstance().subscribeToTopic("general").addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> param1Task) {}
        });
        boolean bool = getSharedPreferences("setNightModeSharedPref", 0).getBoolean(SWITCH3, true);

        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, Home_activity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        },SPLASH_TIME_OUT);
        findViewById(R.id.myLayout).setSystemUiVisibility(4102);
    }

    protected void onStart() {
        super.onStart();
        setNightMode();
    }

    public void saveBool(boolean paramBoolean) {
        SharedPreferences.Editor editor = getSharedPreferences("setNightModeSharedPref", 0).edit();
        editor.putBoolean(SWITCH3, paramBoolean);
        editor.apply();
    }


    public void setNightMode() {
        if (getSharedPreferences("setNightModeSharedPref", 0).getBoolean("switch1", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            return;
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
