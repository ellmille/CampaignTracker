package com.elle.campaigntracker.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.databinding.FragmentEditCharacterStatsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditCharacterStatsFragment extends Fragment {
    private FragmentEditCharacterStatsBinding binding;

    private boolean isNew;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public EditCharacterStatsFragment() {
        // Required empty public constructor
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EditCharacterStatsFragment newInstance(boolean isNew) {
        EditCharacterStatsFragment fragment = new EditCharacterStatsFragment();
        Bundle args = new Bundle();
        args.putBoolean(EditCharacterActivity.ARG_ACTION, isNew);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_character_stats, container, false);

        isNew = getArguments().getBoolean(EditCharacterActivity.ARG_ACTION);

        return binding.getRoot();
    }

}
