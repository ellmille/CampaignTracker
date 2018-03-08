package com.elle.campaigntracker.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerTurnFragment extends Fragment {


    public PlayerTurnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_turn, container, false);
    }

    //on your turn
    //move a distance to your speed
    //take one action
    //bonus action
}
