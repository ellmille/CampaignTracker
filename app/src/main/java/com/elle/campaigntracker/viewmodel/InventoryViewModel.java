package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.databinding.ObservableList;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.Item;

import java.util.List;

/**
 * Prepares data for the UI
 */

public class InventoryViewModel extends AndroidViewModel {
    private final LiveData<List<Item>> observableInventory;
    public ObservableList<Item> inventory;

    public InventoryViewModel(Application application){
        super(application);
        Repo repo = ((App) application).getRepo();
        this.observableInventory = repo.getInventory();
    }

    public LiveData<List<Item>> getObservableInventory(){
        return observableInventory;
    }

    public void setInventory(List<Item> items){
        this.inventory.addAll(items);
    }
}
