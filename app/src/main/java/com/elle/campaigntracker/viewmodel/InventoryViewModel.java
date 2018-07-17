package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Ignore;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Money;

import java.util.List;

/**
 * Prepares data for the UI
 */

public class InventoryViewModel extends AndroidViewModel {
    private LiveData<List<Item>> liveInventory;
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
