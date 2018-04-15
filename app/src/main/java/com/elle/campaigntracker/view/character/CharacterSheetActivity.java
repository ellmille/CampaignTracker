package com.elle.campaigntracker.view.character;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.viewmodel.CharacterSheetViewModel;
import com.elle.campaigntracker.viewmodel.PlayableCharacterViewModel;

public class CharacterSheetActivity extends AppCompatActivity {
    private CharacterSheetViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        viewModel = ViewModelProviders.of(this).get(CharacterSheetViewModel.class);
    }
}
