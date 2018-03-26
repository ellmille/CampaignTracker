package com.elle.campaigntracker.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Alignment;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.databinding.ActivityInventoryBinding;
import com.elle.campaigntracker.view.adapters.InventoryItemAdapter;
import com.elle.campaigntracker.view.callback.FabCallback;
import com.elle.campaigntracker.viewmodel.InventoryViewModel;

import java.util.List;

/**
 * Extends {@link Fragment} to view Inventory
 */

public class InventoryFragment extends Fragment{
    public static final String ARG_ACTION = "add_or_edit";

    private InventoryViewModel viewModel;
    private InventoryItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ActivityInventoryBinding binding = DataBindingUtil.inflate(inflater, R.layout.activity_inventory, container, false);
        binding.setCallback(fabCallback);

        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.list);
        adapter = new InventoryItemAdapter();
        recyclerView.setAdapter(adapter);

        //set view model
        viewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        viewModel.getObservableInventory().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                //throw in binding
                adapter.setItemList(items);
            }
        });

        //return root view
        return binding.getRoot();
    }

    private FabCallback fabCallback = new FabCallback() {
        @Override
        public void onFabClicked() {
            DialogFragment dialogFragment = new AddItemFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ARG_ACTION, true);
            dialogFragment.setArguments(bundle);
            dialogFragment.show(getChildFragmentManager(), "ITEM");
        }
    };

    public void onSave(Item item) {
        viewModel.addToInventory(item);
    }
}
