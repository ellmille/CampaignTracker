package com.elle.campaigntracker.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.databinding.FragmentCharacterSheetBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterSheetFragment extends Fragment {
    private FragmentCharacterSheetBinding binding;

    public CharacterSheetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_sheet, container, false);
        return binding.getRoot();
    }
}
