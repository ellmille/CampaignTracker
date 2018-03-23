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
import com.elle.campaigntracker.view.callback.ItemCallback;
import com.elle.campaigntracker.viewmodel.InventoryViewModel;

import java.util.List;

public class InventoryActivity extends AppCompatActivity implements AddItemFragment.DialogItemCallback{
    private InventoryViewModel viewModel;
    private InventoryItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInventoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_inventory);
        binding.setCallback(itemCallback);

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

    private ItemCallback itemCallback = new ItemCallback() {
        @Override
        public void onItemClicked(Item item) {
            //edit item
            Toast.makeText(InventoryActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFabClicked() {
            //add new item
            Toast.makeText(InventoryActivity.this, "FAB", Toast.LENGTH_SHORT).show();

            DialogFragment dialogFragment = new AddItemFragment();
            dialogFragment.show(getSupportFragmentManager(), "ITEM");
        }
    };

    @Override
    public void onSave(Item item) {
        Toast.makeText(this, item.getName(), Toast.LENGTH_LONG).show();
        //todo: save to DB
        viewModel.addToInventory(item);
    }
}
