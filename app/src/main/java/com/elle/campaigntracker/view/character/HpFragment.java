package com.elle.campaigntracker.view.character;


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
import com.elle.campaigntracker.data.model.PcStats;
import com.elle.campaigntracker.databinding.FragmentHpBinding;
import com.elle.campaigntracker.viewmodel.CharacterSheetViewModel;

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
        viewModel = ViewModelProviders.of(getActivity()).get(CharacterSheetViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hp, container, false);
        binding.setHitDieString(viewModel.getHitDie());
        viewModel.getObservableStats().observe(getActivity(), new Observer<PcStats>() {
            @Override
            public void onChanged(@Nullable PcStats pcStats) {
                binding.setStats(pcStats);
            }
        });
        return binding.getRoot();
    }

}
