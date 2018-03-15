package com.elle.campaigntracker.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.databinding.FragmentUpdateHealthBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateHealthFragment extends DialogFragment {
    public static final String IS_HEALING = "IS_HEALING";
    public static final String HP_CHANGE = "HP_CHANGE";
   // private PlayerCharacter character;
    //are we healing or taking damage?
    private boolean isHealing;

    public UpdateHealthFragment() {
        // Required empty public constructor
    }

    public static UpdateHealthFragment newInstance(boolean isHealing){
        UpdateHealthFragment updateHealthFragment = new UpdateHealthFragment();
        Bundle args = new Bundle();
        args.putBoolean(IS_HEALING, isHealing);
        updateHealthFragment.setArguments(args);
        return updateHealthFragment;
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
        FragmentUpdateHealthBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update_health,
                container, false);
        View view = binding.getRoot();
        binding.setHandler(new HealthHandlers());
        //todo: change label based on healing/hurting
        return view;
    }

    public class HealthHandlers {
        private int hitPoints;

        public void enteredPoints(View view){
            EditText points = (EditText) view;
            this.hitPoints = Integer.valueOf(String.valueOf(points.getText()));
        }
        public void saveHealth(){
            //return points
            Bundle bundle = new Bundle();
            bundle.putBoolean(IS_HEALING, isHealing);
            bundle.putInt(HP_CHANGE, hitPoints);
            //todo: close fragment
        }
    }
}
