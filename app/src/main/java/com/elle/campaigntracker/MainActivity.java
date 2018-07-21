package com.elle.campaigntracker;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.elle.campaigntracker.character.ui.HealthFragment;
import com.elle.campaigntracker.character.viewmodel.PlayableCharacterViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   // ActivityMainBinding binding;
    PlayableCharacterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setup binding
        setContentView(R.layout.activity_main);
  //      binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //setup view model
        viewModel = ViewModelProviders.of(this).get(PlayableCharacterViewModel.class);
    //    binding.setCharViewModel(viewModel);
        subscribeToModel(viewModel);

        setupNavigation();
        setupViewPager();
    }

    private void subscribeToModel(final PlayableCharacterViewModel model){
        //observe character
        model.getObservableCharacter().observe(this, model::setPlayableCharacter);
    }

    //region navigation drawer
    private void setupNavigation(){
        //set up drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //set up nav drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            Toast.makeText(this, "FULL SHEET", Toast.LENGTH_SHORT).show();
        //    Intent intent = new Intent(this, CharacterSheetActivity.class);
        //    startActivity(intent);
        } else if (id == R.id.nav_inventory) {
            Toast.makeText(this, "Inventory activity", Toast.LENGTH_SHORT).show();
        //    Intent intent = new Intent(this, InventoryActivity.class);
        //    startActivity(intent);
        } else if (id == R.id.nav_log) {
            Toast.makeText(this, "LOGS", Toast.LENGTH_SHORT).show();
        //    Intent intent = new Intent(this, LogActivity.class);
         //   startActivity(intent);
        } else if (id == R.id.nav_level){
            Toast.makeText(this, "LEVEL", Toast.LENGTH_SHORT).show();
//            //update Fragment
//            XpFragment fragment = new XpFragment();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
        } else if(id == R.id.nav_edit_char){
            Toast.makeText(this, "EDIT", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, EditPcActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putBoolean(EditPcActivity.ARG_ACTION, false);
//            intent.putExtras(bundle);
//            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //endregion

    //region view pager
    private void setupViewPager(){
        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HealthFragment(), HealthFragment.TAG);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    /**
     * Adapter for {@link ViewPager}
     * Allows swiping to move in between fragments
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
    //endregion
}