package com.corwinminds.hesmb.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.corwinminds.hesmb.Fragment.EnergyDashboard;
import com.corwinminds.hesmb.Fragment.EnergyUsageFragment;
import com.corwinminds.hesmb.Fragment.FireAlarm;
import com.corwinminds.hesmb.Fragment.ReadingFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceFragmentCompat;

import android.view.Menu;
import android.view.MenuItem;

import com.corwinminds.hesmb.Fragment.DashboardFragment;
import com.corwinminds.hesmb.Fragment.ModulesFragment;
import com.corwinminds.hesmb.Fragment.ProfileFragment;
import com.corwinminds.hesmb.R;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FireAlarm.newInstance());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment selectedFragment = null;
        int id = item.getItemId();
        if(id==R.id.firealarm)
        {
            selectedFragment=FireAlarm.newInstance();
        } else if(id == R.id.dashboard) {
            selectedFragment= EnergyDashboard.newInstance();
        }
        else if (id == R.id.modules) {
            selectedFragment = ReadingFragment.newInstance();
        }
        else if (id == R.id.setting) {
            selectedFragment = new MySettingsFragment();
        }
        else if (id == R.id.energyusage) {
            selectedFragment= EnergyUsageFragment.newInstance();

            }
            //selectedFragment = DashboardFragment.newInstance();
        /* else if (id == R.id.modules) {
            //selectedFragment = ModulesFragment.newInstance();
        } else if (id == R.id.profile) {
            //selectedFragment = ProfileFragment.newInstance();
        } else if (id == R.id.settings) {
           // selectedFragment=new MySettingsFragment();



        } else if (id == R.id.label) {

        }
*/
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public static class MySettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.setting_screen, rootKey);

        }
    }
}
