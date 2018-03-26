package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Ignore;
import android.databinding.ObservableField;
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
    public ObservableField<Item> item;
    private final Repo repo;

    public InventoryViewModel(Application application){
        super(application);
        this.repo = ((App) application).getRepo();
        this.observableInventory = repo.getInventory();
        this.item = new ObservableField<Item>();
    }

    public LiveData<List<Item>> getObservableInventory(){
        return observableInventory;
    }

    public void setInventory(List<Item> items){
        this.inventory.addAll(items);
    }

    public void setItem(Item item){
        this.item.set(item);
    }

    public Item getItem(){
        return this.item.get();
    }

    public void updateItem(Item item){
        item.setCharId(repo.getCharId());
        repo.updateItem(item);
    }
}
