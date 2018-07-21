package com.elle.campaigntracker.character.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.databinding.FragmentXpBinding;
import com.elle.campaigntracker.character.viewmodel.PlayableCharacterViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass to Edit XP
 */
public class XpFragment extends Fragment {
    private FragmentXpBinding binding;

    public XpFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        PlayableCharacterViewModel viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(PlayableCharacterViewModel.class);
        subscribeToModel(viewModel);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_xp, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void subscribeToModel(PlayableCharacterViewModel viewModel){
        viewModel.getObservableCharacter().observe(Objects.requireNonNull(getActivity()),
                playableCharacter -> binding.setPlayableCharacter(playableCharacter));
    }
}
