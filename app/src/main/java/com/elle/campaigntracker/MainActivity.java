package com.elle.campaigntracker;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.elle.campaigntracker.data.character.PlayerCharacter;
import com.elle.campaigntracker.data.repo.DummyRepo;
import com.elle.campaigntracker.databinding.ActivityMainBinding;
import com.elle.campaigntracker.view.PlayerTurnActivity;
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

        //todo: remove/refactor
        new DummyRepo();
        character = DummyRepo.getRex();

        //get last used character
        binding.setHandler(new Handler());
        binding.setCharacter(character);

    }

    private Context getContext(){
        return this;
    }

    public class Handler {
        public void updateHealth(boolean isHealing){
            UpdateHealthFragment updateHealthFragment = UpdateHealthFragment.newInstance(isHealing);
            updateHealthFragment.show(getSupportFragmentManager(), "dialog");
        }
        public void startTurn(PlayerCharacter character){
            System.out.println(character.getCharacterName());

            Intent intent = new Intent(getContext(), PlayerTurnActivity.class);
            getContext().startActivity(intent);
        }
    }
}
