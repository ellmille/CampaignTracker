package com.elle.campaigntracker.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.databinding.ActivityMainBinding;
import com.elle.campaigntracker.viewmodel.PlayableCharacterViewModel;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding;
    PlayableCharacterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setup binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //set up drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //set up nav drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //setup view model
        viewModel = ViewModelProviders.of(this).get(PlayableCharacterViewModel.class);
        binding.setCharViewModel(viewModel);
        subscribeToModel(viewModel);

        //add health fragment if this is first creation
        if(savedInstanceState == null){
            HealthFragment fragment = new HealthFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, HealthFragment.TAG).commit();
        }
    }

    private void subscribeToModel(final PlayableCharacterViewModel model){
        //observe character
        model.getObservableCharacter().observe(this, new Observer<PlayableCharacter>() {
            @Override
            public void onChanged(@Nullable PlayableCharacter playableCharacter) {
                model.setPlayableCharacter(playableCharacter);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_full_sheet) {
            // Handle the camera action
        } else if (id == R.id.nav_inventory) {
            Intent intent = new Intent(this, InventoryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_log) {
            Intent intent = new Intent(this, LogActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_level){
            //update Fragment
            XpFragment fragment = new XpFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}