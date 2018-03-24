package com.elle.campaigntracker.view;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.viewmodel.PlayableCharacterViewModel;

/**
 * A simple {@link Fragment} subclass to Edit XP
 */
public class XpFragment extends Fragment {
    public static final String TAG = "XP";
    private PlayableCharacterViewModel viewModel;
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xp, container, false);
    }

}
