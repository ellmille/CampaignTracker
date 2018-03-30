package com.elle.campaigntracker.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.databinding.FragmentEditMoneyBinding;

/**
 * A {@link DialogFragment} to change money amount.
 */
public class EditMoneyFragment extends DialogFragment {
    public static final String IS_SPENDING_KEY = "SPENDING";
  //  private InventoryViewModel viewModel;
    private FragmentEditMoneyBinding binding;

    public EditMoneyFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
     //   viewModel = ViewModelProviders.of(getActivity()).get(InventoryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_money, container, false);
        binding.setIsSpending(getArguments().getBoolean(IS_SPENDING_KEY));
        binding.setAmount(10);
        //todo: set callback
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}
