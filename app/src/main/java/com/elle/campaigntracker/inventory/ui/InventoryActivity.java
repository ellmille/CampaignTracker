package com.elle.campaigntracker.inventory.ui;

import android.support.v4.app.DialogFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.inventory.Item;
import com.elle.campaigntracker.databinding.ActivityInventoryBinding;
import com.elle.campaigntracker.inventory.ui.InventoryItemAdapter;
import com.elle.campaigntracker.view.EditItemFragment;
import com.elle.campaigntracker.view.EditMoneyFragment;
import com.elle.campaigntracker.view.callback.ClickCallback;
import com.elle.campaigntracker.view.callback.FabCallback;
import com.elle.campaigntracker.inventory.viewmodel.InventoryViewModel;

import java.util.List;

public class InventoryActivity extends AppCompatActivity implements EditItemFragment.DialogItemCallback, EditMoneyFragment.DialogMoneyCallback {
    public static final String ARG_ACTION = "add_or_edit";
    public static final String ARG_ID = "item_id";
    private InventoryViewModel viewModel;
    private InventoryItemAdapter adapter;

    // todo: do you want this to be a fragment?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInventoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_inventory);
        binding.setCallback(fabCallback);

        RecyclerView recyclerView = findViewById(R.id.list);
        adapter = new InventoryItemAdapter(itemClickCallback);
        recyclerView.setAdapter(adapter);
        //set view model
        viewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        viewModel.getLiveInventory().observe(this, new Observer<List<Item>>() {
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
            DialogFragment dialogFragment = new EditItemFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ARG_ACTION, true);
            dialogFragment.setArguments(bundle);
            dialogFragment.show(getSupportFragmentManager(), "ITEM");
        }
    };

    private ClickCallback.ItemClick itemClickCallback = new ClickCallback.ItemClick() {
        @Override
        public void onClick(Item item) {
            viewModel.setSelected(item);
            //open fragment
            DialogFragment dialogFragment = new EditItemFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ARG_ACTION, false);
            bundle.putInt(ARG_ID, item.getId());
            dialogFragment.setArguments(bundle);
            dialogFragment.show(getSupportFragmentManager(), "ITEM");
        }
    };

    @Override
    public void onSave(Item item) {
        viewModel.insert(item);
    }

    @Override
    public void onDelete(Item item) {
        viewModel.delete(item);
    }

    @Override
    public void onSaveMoney(int amount, String type, boolean isSpending) {
//        Money money = viewModel.getObservableMoney().getValue();
//        if(money == null){
//            //todo: get char id
//            money = new Money(0, 0, 0, 0, 0, 0);
//            viewModel.setMoney(money);
//        }
//        switch (type){
//            case "Gold":
//                money.updateGold(amount, isSpending);
//                break;
//            case "Silver":
//                money.updateSilver(amount, isSpending);
//                break;
//            case "Copper":
//                money.updateCopper(amount, isSpending);
//                break;
//            case "Electrum":
//                money.updateElectrum(amount, isSpending);
//                break;
//            case "Platinum":
//                money.updatePlatinum(amount, isSpending);
//                break;
//            default:
//                break;
//        }
//        viewModel.updateMoney(money);
    }
}
