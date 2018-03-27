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
public class EditPcInfoFragment extends Fragment {
    private FragmentEditCharacterStatsBinding binding;

    private boolean isNew;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public EditPcInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EditPcBasicsFragment newInstance(boolean isNew) {
        EditPcBasicsFragment fragment = new EditPcBasicsFragment();
        Bundle args = new Bundle();
        args.putBoolean(EditPcActivity.ARG_ACTION, isNew);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_character_info, container, false);

        isNew = getArguments().getBoolean(EditPcActivity.ARG_ACTION);

        return binding.getRoot();
    }

}
