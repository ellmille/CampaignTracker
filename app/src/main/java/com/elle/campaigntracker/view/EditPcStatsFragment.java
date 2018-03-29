package com.elle.campaigntracker.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.PcStats;
import com.elle.campaigntracker.databinding.FragmentEditCharacterStatsBinding;
import com.elle.campaigntracker.view.callback.SaveCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditPcStatsFragment extends Fragment {
    private FragmentEditCharacterStatsBinding binding;

    private boolean isNew;

    public EditPcStatsFragment() {
        // Required empty public constructor
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EditPcStatsFragment newInstance(boolean isNew) {
        EditPcStatsFragment fragment = new EditPcStatsFragment();
        Bundle args = new Bundle();
        args.putBoolean(EditPcActivity.ARG_ACTION, isNew);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_character_stats, container, false);
        binding.setCallback(statsCallback);
        isNew = getArguments().getBoolean(EditPcActivity.ARG_ACTION);
        if(isNew){
            binding.setStats(new PcStats());
        }else{
            //todo: view model
        }
        return binding.getRoot();
    }

    private SaveCallback.PcStats statsCallback = new SaveCallback.PcStats(){
        @Override
        public void onSave(PcStats stats) {

        }
    };
}
