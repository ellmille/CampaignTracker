package com.elle.campaigntracker.view.character;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.PcStats;
import com.elle.campaigntracker.databinding.FragmentHpBinding;
import com.elle.campaigntracker.view.callback.DeathSavingCallback;
import com.elle.campaigntracker.viewmodel.CharacterSheetViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HpFragment extends Fragment {
    private FragmentHpBinding binding;
    private CharacterSheetViewModel viewModel;

    public HpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CharacterSheetViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hp, container, false);
        binding.setHitDieString(viewModel.getHitDie());
        binding.setCallback(deathSavingCallback);
        viewModel.getObservableStats().observe(Objects.requireNonNull(getActivity()), new Observer<PcStats>() {
            @Override
            public void onChanged(@Nullable PcStats pcStats) {
                binding.setStats(pcStats);
            }
        });
        return binding.getRoot();
    }

    private DeathSavingCallback deathSavingCallback = new DeathSavingCallback() {
        @Override
        public void onDeathSave(int retry) {
            if(retry == 3){
                Toast.makeText(getActivity(), "Congrats on living", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onDeathFail(int retry) {
            if(retry == 3) {
                Toast.makeText(getActivity(), "Whoops", Toast.LENGTH_LONG).show();
            }
        }
    };
}
