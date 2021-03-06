package com.elle.campaigntracker.character.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.character.PlayableCharacter;
import com.elle.campaigntracker.databinding.FragmentHealthBinding;
import com.elle.campaigntracker.character.viewmodel.PlayableCharacterViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends Fragment {
    public static final String TAG = "HEALTH";
    private PlayableCharacterViewModel viewModel;
    private FragmentHealthBinding binding;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(PlayableCharacterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_health, container, false);
        binding.setCallback(healthCallback);
        binding.setPoints("1");

        viewModel.getObservableCharacter().observe(this, new Observer<PlayableCharacter>() {
            @Override
            public void onChanged(@Nullable PlayableCharacter playableCharacter) {
                binding.setPlayableCharacter(playableCharacter);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private final HealthCallback healthCallback = new HealthCallback() {
        @Override
        public void heal(String hp) {
            int newPoints = viewModel.playableCharacter.get().getCurrentHp() + Integer.parseInt(hp);
            viewModel.updatePlayableCharacterHealth(newPoints);
        }

        @Override
        public void takeDamage(String hp) {
            int newPoints = viewModel.playableCharacter.get().getCurrentHp() - Integer.parseInt(hp);
            viewModel.updatePlayableCharacterHealth(newPoints);
        }
    };
}
