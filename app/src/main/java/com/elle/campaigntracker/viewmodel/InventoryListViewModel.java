package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.entity.InventoryItemEntity;

import java.util.List;

/**
 * View model for our inventory
 */

public class InventoryListViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<InventoryItemEntity>> observableInventory;
    private final int playerCharacterId;

    public InventoryListViewModel(@NonNull Application application, Repo repo, final int characterId) {
        super(application);
        playerCharacterId = characterId;

        observableInventory = new MediatorLiveData<>();
        observableInventory.setValue(null);
        //todo: pass in char ID
        LiveData<List<InventoryItemEntity>> inventory = ((App) application).getRepo().getItems(playerCharacterId);

        observableInventory.addSource(inventory, observableInventory::setValue);
    }

    /**
     * Expose the LiveData Inventory query so the UI can observe it.
     */
    public LiveData<List<InventoryItemEntity>> getInventory() {
        return observableInventory;
    }

    /**
     * A creator is used to inject the character ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels.
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Application application;

        private final int characterId;

        private final Repo repo;

        public Factory(@NonNull Application applicationIn, int charId) {
            application = applicationIn;
            characterId = charId;
            repo = ((App) application).getRepo();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new InventoryListViewModel(application, repo, characterId);
        }
    }
}
