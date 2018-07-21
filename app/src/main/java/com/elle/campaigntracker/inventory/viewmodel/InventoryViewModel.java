package com.elle.campaigntracker.inventory.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.inventory.Item;
import com.elle.campaigntracker.wallet.Money;

import java.util.List;

/**
 * Prepares data for the UI
 */

public class InventoryViewModel extends AndroidViewModel {
    private LiveData<List<Item>> liveInventory;
    private LiveData<Money> liveMoney;
    private MutableLiveData<Item> selected = new MutableLiveData<>();
    private final Repo repo;

    public InventoryViewModel(Application application){
        super(application);
        this.repo = ((App) application).getRepo();
        this.liveInventory = repo.getInventoryLiveData();
    }

    public LiveData<List<Item>> getLiveInventory() {
        return liveInventory;
    }

    public LiveData<Money> getLiveMoney() {
        return liveMoney;
    }

    public void insert(Item item){
        repo.insert(item);
    }

    public void delete(Item item){
        repo.delete(item);
    }

    public void setSelected(Item item){
        this.selected.setValue(item);
    }

    public LiveData<Item> getSelected(){
        return selected;
    }
}
