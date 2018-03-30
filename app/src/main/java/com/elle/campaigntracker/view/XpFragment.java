package com.elle.campaigntracker.view;


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
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.databinding.FragmentXpBinding;
import com.elle.campaigntracker.view.callback.HealthCallback;
import com.elle.campaigntracker.viewmodel.PlayableCharacterViewModel;

/**
 * A simple {@link Fragment} subclass to Edit XP
 */
public class XpFragment extends Fragment {
    public static final String TAG = "XP";
    private PlayableCharacterViewModel viewModel;
    private FragmentXpBinding binding;
    //todo: will need it's own callback and make it easier to add points
    //todo: we only want to edit if there was a mistake


    public XpFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(PlayableCharacterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_xp, container, false);
        binding.setCallback(xpCallback);
        binding.setPoints("1");
        viewModel.getObservableCharacter().observe(getActivity(), new Observer<PlayableCharacter>() {
            @Override
            public void onChanged(@Nullable PlayableCharacter playableCharacter) {
                binding.setPlayableCharacter(playableCharacter);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    private final HealthCallback xpCallback = new HealthCallback() {
        @Override
        public void heal(String hp) {
            int newPoints = viewModel.playableCharacter.get().getCurrentXp() + Integer.parseInt(hp);
            viewModel.updatePlayableCharacterXp(newPoints);
        }

        @Override
        public void takeDamage(String hp) {
            int newPoints = viewModel.playableCharacter.get().getCurrentXp() - Integer.parseInt(hp);
            viewModel.updatePlayableCharacterXp(newPoints);
        }
    };
}
