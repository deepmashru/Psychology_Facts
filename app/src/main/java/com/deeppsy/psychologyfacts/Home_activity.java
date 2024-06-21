package com.deeppsy.psychologyfacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home_activity extends AppCompatActivity {
    static BottomNavigationView bottomNavigationView;
    static int aAdvertisment = 1;
    boolean isSavedFrg = false;
    //private InterstitialAd interstitialAd;
    Menu menu;
    //creating a drawer variable to access drawer;
    private DrawerLayout drawerLayout;

    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setElevation(5.0F);
        toolbar.setBackgroundColor(getColor(R.color.toolBarColor));
        toolbar.setTitleTextColor(getColor(R.color.maincolor));
        this.drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        BottomNavigationView bottomNavigationView1 = findViewById(R.id.bottom_view);
        actionBarDrawerToggle.syncState();
        bottomNavigationView = bottomNavigationView1;
        bottomNavigationView.setVisibility(View.VISIBLE);
        // interstitialAd = new InterstitialAd(this,"301374014310161_301915027589393");
        // this.interstitialAd.loadAd();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem param1MenuItem) {
                Fragment fragment;
                int i = param1MenuItem.getItemId();
                if (i == R.id.home) {
                    fragment = new HomeFragment();
                    Home_activity.this.isSavedFrg = false;
                } else if (i != R.id.bookmark) {
                    fragment = null;
                } else {
                    fragment = new SaveFragment();
                    Home_activity.this.isSavedFrg = true;
                }
                Home_activity.this.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });
        ((NavigationView)
                findViewById(R.id.bottom_view1)).setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.share:
                                Intent intent = new Intent("android.intent.action.SEND");
                                intent.setType("text/plain");
                                intent.putExtra("android.intent.extra.TEXT", "Download PsychologyApp:\nPsychology Facts app provides mind-blowing psychology facts and life hacks that everyone should know \nDownload Now: \nhttps://play.google.com/store/apps/details?id=com.deeppsy.psychologyfacts");
                                intent.putExtra("android.intent.extra.SUBJECT", "pub:AARUSH");
                                Home_activity.this.startActivity(Intent.createChooser(intent, "Share Using"));
                                break;
                            case R.id.sharing:
                                Home_activity.this.drawerLayout.closeDrawer(GravityCompat.START);//TODO look gravity maybe is a big question here
                                intent = new Intent(Home_activity.this, SettingsActivity.class);
                                Home_activity.this.startActivity(intent);
                                break;
                            case R.id.rate:
                                Home_activity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.deeppsy.psychologyfacts")));
                                break;
                            case R.id.randomFacts:
                                Home_activity.this.drawerLayout.closeDrawer(GravityCompat.START);
                                intent = new Intent(Home_activity.this, All_facts_together.class);
                                intent.putExtra("position", "Random");
                                Home_activity.this.startActivity(intent);
                                break;
                            case R.id.more:
                                Intent intentx = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pub:AARUSH"));
                                Home_activity.this.startActivity(intentx);

                                break;
                            case R.id.home:
                                Home_activity.this.drawerLayout.closeDrawer(GravityCompat.START);
                                Home_activity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                                Home_activity.bottomNavigationView.setSelectedItemId(R.id.home);//TODO
                                break;
                            case R.id.factOfTheDay:
                                intent = new Intent(Home_activity.this, FactOfTheDayActivity.class);
                                Home_activity.this.startActivity(intent);
                                Home_activity.this.drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.feedBack:
                                intent = new Intent("android.intent.action.SEND");
                                intent.setType("text/email");
                                intent.putExtra("android.intent.extra.EMAIL", new String[]{"rj.harsh3@gmail.com"});
                                intent.putExtra("android.intent.extra.SUBJECT", "Feedback");
                                intent.putExtra("android.intent.extra.TEXT", "i am facing an issue...");
                                Home_activity.this.startActivity(Intent.createChooser(intent, "Select email app."));
                                break;
                            case R.id.smartFacts:
                                Home_activity.this.drawerLayout.closeDrawer(GravityCompat.START);
                                intent = new Intent(Home_activity.this, All_facts_together.class);
                                intent.putExtra("position", "Human Mind");
                                Home_activity.this.startActivity(intent);
                                break;
                            case R.id.about:
                                Intent intent1 = new Intent(Home_activity.this, About_of_this_app.class);
                                Home_activity.this.startActivity(intent1);
                                Home_activity.this.drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                        }
                        return false;//TODO
                    }
                });
    }

    public boolean onCreateOptionsMenu(Menu mMenu) {
        this.menu = mMenu;
        getMenuInflater().inflate(R.menu.menu, mMenu);
        SearchView searchView = (SearchView) mMenu.findItem(R.id.search).getActionView();
        searchView.setImeOptions(6);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String param1String) {
                if (Home_activity.this.isSavedFrg) {
                    SaveFragment.favAdapter.getFilter().filter(param1String);
                } else {
                    HomeFragment.factAdapter.getFilter().filter(param1String);
                }
                return false;
            }

            public boolean onQueryTextSubmit(String param1String) {
                return false;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu) {
        if (menu.getItemId() == R.id.setiing)
            startActivity(new Intent(this, SettingsActivity.class));
        else if (menu.getItemId() == R.id.moreapps1) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pub:AARUSH"));
            Home_activity.this.startActivity(intent);
        } else if (menu.getItemId() == R.id.rate1) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.deeppsy.psychologyfacts"));
            Home_activity.this.startActivity(intent);
        } else if (menu.getItemId() == R.id.search) {
            if (aAdvertisment == 1) {
                // if (interstitialAd.isAdLoaded()){
                //   interstitialAd.show();
                aAdvertisment++;
                //}
                aAdvertisment++;
            }
        }
        return super.onOptionsItemSelected(menu);
    }
}
