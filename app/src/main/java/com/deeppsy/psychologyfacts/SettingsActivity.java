package com.deeppsy.psychologyfacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
//    static final String APP_NAME = "com.deeppsy.psychologyfacts";

    public static final String SHARED_PREF = "setNightModeSharedPref";

    // public static final String SWITCH1 = "switch1";

    // public static final String SWITCH2 = "switch2";

    //private static final String job_tag = "Notification";

    public static boolean switchOnOff = false;

    ListView listView;

    Switch nightSwitch;


    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, 0);
        ListView listView1 = findViewById(R.id.list);
        this.listView = listView1;
        listView1.setDividerHeight(0);
        this.listView.setDivider(null);
        RelativeLayout relativeLayout1 = findViewById(R.id.rlayout1);
        this.nightSwitch = findViewById(R.id.nightButton);
        boolean bool = sharedPreferences.getBoolean("switch1", false);
        switchOnOff = bool;
        this.nightSwitch.setChecked(bool);
        // bool = sharedPreferences.getBoolean("switch2", true);

        final Intent intent = new Intent(this, Home_activity.class);
        intent.setFlags(Intent.FLAG_FROM_BACKGROUND);
        this.nightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean x) {
                if (SettingsActivity.switchOnOff) {
                    SettingsActivity.this.nightSwitch.setChecked(false);
                    SettingsActivity.this.saveData(false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SettingsActivity.this.finish();
                    SettingsActivity.this.startActivity(intent);
                    return;
                }
                SettingsActivity.this.nightSwitch.setChecked(true);
                SettingsActivity.this.saveData(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                SettingsActivity.this.finish();
                SettingsActivity.this.startActivity(intent);
            }
        });
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                if (SettingsActivity.this.nightSwitch.isChecked()) {
                    SettingsActivity.this.nightSwitch.setChecked(false);
                    SettingsActivity.this.saveData(false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SettingsActivity.this.finish();
                    SettingsActivity.this.startActivity(intent);
                    return;
                }
                SettingsActivity.this.nightSwitch.setChecked(true);
                SettingsActivity.this.saveData(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                SettingsActivity.this.finish();
                SettingsActivity.this.startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Settings");
        toolbar.setBackgroundColor(getColor(R.color.backColor));
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()
        ).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<FactData> arrayList = new ArrayList<>();
        //  arrayList.add(new FactData("Share feedback", R.drawable.ic_email_black_24dp));// TODO look at this fucking images
        arrayList.add(new FactData("Rate Us", R.drawable.ic_google));
        arrayList.add(new FactData("Invite Friends", R.drawable.ic_like));
        arrayList.add(new FactData("Terms & Conditions", R.drawable.ic_baseline_verified_user_24));
        // arrayList.add(new FactData("Privacy Policy", R.drawable.ic_paper_plane));//TODO
        arrayList.add(new FactData("More Apps", R.drawable.ic_search));
        arrayList.add(new FactData("Developer Name", R.drawable.ic_developer));
        arrayList.add(new FactData("About Us", R.drawable.ic_about));
        this.listView.setAdapter(new AndroidSettingsAdapter(this, arrayList));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = "android.intent.extra.TEXT";
                String str2 = "android.intent.extra.SUBJECT";
                String str3 = "android.intent.action.SEND";
                String str4 = "android.intent.action.VIEW";
                if (i == 1) {
                    Intent intent = new Intent(str3);
                    intent.setType("text+" +
                            "/plain");
                    intent.putExtra(str, "Download PsychologyApp:\nPsychology Facts app provides mind-blowing psychology facts and life hacks that everyone should know \nDownload Now: \nhttps://play.google.com/store/apps/details?id=com.deeppsy.psychologyfacts");
                    SettingsActivity.this.startActivity(Intent.createChooser(intent, "Share Using"));
                } else if (i == 2) {
                    Toast.makeText(SettingsActivity.this, "update soon....", Toast.LENGTH_SHORT).show();
                } else if (i == 5) {
                    SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, About_of_this_app.class));
                } else if (i == 3) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pub:AARUSH"));
                    SettingsActivity.this.startActivity(intent);

                } else if (i == 4) {
                    Toast.makeText(SettingsActivity.this, "this app is developed by DEEP MASHRU", Toast.LENGTH_LONG).show();
                } else {
                    SettingsActivity.this.startActivity(new Intent(str4, Uri.parse("market://details?id=com.deeppsy.psychologyfacts")));
                }
            }

        });
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == android.R.id.home) {
            finish();
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void saveData(boolean paramBoolean) {
        SharedPreferences.Editor editor = getSharedPreferences("setNightModeSharedPref", 0).edit();
        editor.putBoolean("switch1", paramBoolean);
        editor.apply();
    }
}


