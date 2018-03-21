package com.elle.campaigntracker.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.DummyRepo;
import com.elle.campaigntracker.databinding.FragmentCharacterSheetBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterSheetFragment extends Fragment {
    private PlayableCharacter rex;

    public CharacterSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        DummyRepo dummyRepo = new DummyRepo();
        rex = dummyRepo.getPlayableChar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCharacterSheetBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_sheet,
                container, false);
        View view = binding.getRoot();
        binding.setCharacter(rex);
        return view;
    }

}
