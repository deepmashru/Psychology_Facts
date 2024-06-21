package com.deeppsy.psychologyfacts;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;

public class FavViewPagerActivity extends AppCompatActivity {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_fav_view_pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setElevation(0.0F);
        toolbar.setBackgroundColor(getColor(R.color.viewpagerToolBarColor));
        toolbar.setTitleTextColor(getColor(R.color.viewpagerToolBarColor));
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ViewPager viewPager = findViewById(R.id.viewpager_fav);
        int i = getIntent().getIntExtra("position", 0);
        viewPager.setAdapter(new FavViewPagerAdapter(this, SaveFragment.favData));
        viewPager.setCurrentItem(i);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.viewpager_menu_detail, paramMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == android.R.id.home) {
            finish();
            onBackPressed();
        } else if (paramMenuItem.getItemId() == R.id.share) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", "Download PsychologyApp:\nPsychology Facts app provides mind-blowing psychology facts and life hacks that everyone should know \nDownload Now: \nhttps://play.google.com/store/apps/details?id=com.vairagii.psychologyfacts");
            startActivity(intent.putExtra("android.intent.extra.SUBJECT", "EarthquakeApp").createChooser(intent, "Share Using"));
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}
