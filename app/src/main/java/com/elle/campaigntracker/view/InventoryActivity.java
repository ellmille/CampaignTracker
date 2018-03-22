package com.elle.campaigntracker.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.viewmodel.InventoryViewModel;

public class InventoryActivity extends AppCompatActivity {
    private InventoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        //todo: add recycler view, binding and adapter
        //set view model
        viewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
    }
}
