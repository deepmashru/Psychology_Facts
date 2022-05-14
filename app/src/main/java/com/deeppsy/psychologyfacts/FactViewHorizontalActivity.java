package com.deeppsy.psychologyfacts;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Objects;

public class FactViewHorizontalActivity extends AppCompatActivity {
    FactViewPagerAdapter factViewPagerAdapter;

    ArrayList<FactData> listOFFacts;

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(DetailAdapterForAllFacts.SHARED_FAV, 0);
        ArrayList arrayList = (ArrayList)
                (new Gson()).fromJson(sharedPreferences.getString
                                (All_facts_together.ARRAY_LIST_OF_FACTS,
                                null),
                (new TypeToken<ArrayList<FactData>>() {

        }).getType());
        this.listOFFacts = arrayList;
        if (arrayList == null)
            this.listOFFacts = new ArrayList();
    }

    public void onBackPressed() { super.onBackPressed(); }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fact_view_horizontal);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setElevation(0.0F);
        toolbar.setBackgroundColor(getColor(R.color.viewpagerToolBarColor));
        toolbar.setTitleTextColor(getColor(R.color.viewfull));
        setSupportActionBar(toolbar);
        ((ActionBar)Objects.requireNonNull(getSupportActionBar()))
                .setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager_view);
        int i = getIntent().getIntExtra("position", 0);
        loadData();
        FactViewPagerAdapter factViewPagerAdapter1 = new FactViewPagerAdapter(this, this.listOFFacts);
        this.factViewPagerAdapter = factViewPagerAdapter1;
        viewPager.setAdapter(factViewPagerAdapter1);
        viewPager.setCurrentItem(i);
    }

    public boolean onCreateOptionsMenu(Menu mMenu) {
        getMenuInflater().inflate(R.menu.viewpager_menu_detail, mMenu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mMenuItem) {
        if (mMenuItem.getItemId() == android.R.id.home) {//TODO
            finish();
            super.onBackPressed();
        } else if (mMenuItem.getItemId() == R.id.sharing) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", "Download PsychologyApp:\nPsychology Facts app provides mind-blowing psychology facts and life hacks that everyone should know \nDownload Now: \nhttps://play.google.com/store/apps/details?id=com.deeppsy.psychologyfacts");
            intent.putExtra("android.intent.extra.SUBJECT","hey");//TODO
            startActivity(Intent.createChooser(intent,"share Using :)"));
        }
        return super.onOptionsItemSelected(mMenuItem);
    }
}
