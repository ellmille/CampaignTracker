package com.elle.campaigntracker;

import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.elle.campaigntracker.data.character.PlayerCharacter;
import com.elle.campaigntracker.data.repo.DummyRepo;
import com.elle.campaigntracker.databinding.ActivityMainBinding;
import com.elle.campaigntracker.view.UpdateHealthFragment;

public class MainActivity extends AppCompatActivity {
    private PlayerCharacter character;
    ActivityMainBinding binding;

    //todo: add activity contract
    //todo: add menu --> option to view character sheet, start turn, take damage, heal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //get last used character
        DummyRepo dummyRepo = new DummyRepo();
        character = dummyRepo.getRex();
        binding.setHandler(new Handler());
        binding.setCharacter(character);
    }

    public class Handler {
        public void updateHealth(boolean isHealing){
            UpdateHealthFragment updateHealthFragment = UpdateHealthFragment.newInstance(isHealing);
            updateHealthFragment.show(getSupportFragmentManager(), "dialog");
        }
        public void startTurn(){

        }
    }
}
