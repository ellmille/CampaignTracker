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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Alignment;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.databinding.FragmentEditPlayableCharacterBinding;
import com.elle.campaigntracker.viewmodel.PlayableCharacterViewModel;

/**
 * A Fragment for editing character basics
 */

public class EditCharacterBasicsFragment extends Fragment{
    private FragmentEditPlayableCharacterBinding binding;
    private PlayableCharacterViewModel viewModel;
    private boolean isNew;

    public EditCharacterBasicsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EditCharacterBasicsFragment newInstance(boolean isNew) {
        EditCharacterBasicsFragment fragment = new EditCharacterBasicsFragment();
        Bundle args = new Bundle();
        args.putBoolean(EditCharacterActivity.ARG_ACTION, isNew);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(PlayableCharacterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_playable_character, container, false);
        binding.setCallback(playableCharacterCallback);
        isNew = getArguments().getBoolean(EditCharacterActivity.ARG_ACTION);
        if(isNew){
            binding.setPlayableCharacter(new PlayableCharacter());
        }else{
            //get character from view model and observe
            viewModel.getObservableCharacter().observe(this, new Observer<PlayableCharacter>() {
                @Override
                public void onChanged(@Nullable PlayableCharacter playableCharacter) {
                    binding.setPlayableCharacter(playableCharacter);
                }
            });
        }
        Spinner spinner = binding.getRoot().findViewById(R.id.editAlignment);
        spinner.setAdapter(new ArrayAdapter<Alignment>(getActivity(), R.layout.support_simple_spinner_dropdown_item, Alignment.values()));
        //return root view
        return binding.getRoot();
    }

    private PlayableCharacterCallback playableCharacterCallback = new PlayableCharacterCallback() {
        @Override
        public void onSave(PlayableCharacter playableCharacter) {
            viewModel.updatePlayableCharacter(playableCharacter);
        }
    };

    private interface PlayableCharacterCallback{
        void onSave(PlayableCharacter playableCharacter);
    }
}
