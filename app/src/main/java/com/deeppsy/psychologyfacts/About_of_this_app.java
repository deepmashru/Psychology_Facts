package com.deeppsy.psychologyfacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class About_of_this_app extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        findViewById(R.id.aboutActivity).setSystemUiVisibility(4100);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("About");
        toolbar.setBackgroundColor(getColor(R.color.aboutBackColor));
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.detailLinear).setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pub:AARUSH"));
                About_of_this_app.this.startActivity(intent);

            }
        });
        findViewById(R.id.relativeLayout).setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/email");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"aarushp1993@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Feedback");
                intent.putExtra("android.intent.extra.TEXT", "i have noticed...");
                About_of_this_app.this.startActivity(Intent.createChooser(intent, "Select email app."));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem MMENU) {
        if (MMENU.getItemId() == android.R.id.home) {
            finish();
            onBackPressed();
        }
        return super.onOptionsItemSelected(MMENU);
    }
}


