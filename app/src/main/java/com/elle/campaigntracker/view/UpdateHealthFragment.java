package com.elle.campaigntracker.view;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.character.PlayerCharacter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateHealthFragment extends DialogFragment {
    public static final String IS_HEALING = "IS_HEALING";
   // private PlayerCharacter character;
    //are we healing or taking damage?
    private boolean isHealing;

    public UpdateHealthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            isHealing = bundle.getBoolean(IS_HEALING, false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_health, container, false);
    }

    public class HealthHandlers {
        public void addHealth(int points){

        }
        public void takeDamage(int points){

        }
        public void saveHealth(View view){

        }
    }
}
