package com.elle.campaigntracker.view;

import android.support.v4.app.DialogFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.databinding.ActivityInventoryBinding;
import com.elle.campaigntracker.view.adapters.InventoryItemAdapter;
import com.elle.campaigntracker.view.callback.FabCallback;
import com.elle.campaigntracker.view.callback.ItemCallback;
import com.elle.campaigntracker.viewmodel.InventoryViewModel;

import java.util.List;

public class InventoryActivity extends AppCompatActivity implements AddItemFragment.DialogItemCallback{
    public static final String ARG_ACTION = "add_or_edit";
    private InventoryViewModel viewModel;
    private InventoryItemAdapter adapter;

    //todo: allow edit/deleting on item click,
    // todo: use card view? do you want this to be a fragment?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInventoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_inventory);
        binding.setCallback(fabCallback);

        RecyclerView recyclerView = findViewById(R.id.list);
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
    }

    private FabCallback fabCallback = new FabCallback() {
        @Override
        public void onFabClicked() {
            DialogFragment dialogFragment = new AddItemFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ARG_ACTION, true);
            dialogFragment.setArguments(bundle);
            dialogFragment.show(getSupportFragmentManager(), "ITEM");
        }
    };

    @Override
    public void onSave(Item item) {
        viewModel.addToInventory(item);
    }
}
