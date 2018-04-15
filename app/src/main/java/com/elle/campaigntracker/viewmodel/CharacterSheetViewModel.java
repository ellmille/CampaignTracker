package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.PcStats;
import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.PcInfo;

/**
 * ViewModel prepares data for the UI
 */

public class CharacterSheetViewModel extends AndroidViewModel {
    private final LiveData<PlayableCharacter> observableCharacter;
    private final LiveData<PcStats> observableStats;
    private final LiveData<PcInfo> observableInfo;
    private final Repo repo;

    public CharacterSheetViewModel(@NonNull Application application) {
        super(application);
        this.repo = ((App) application).getRepo();
        this.observableCharacter = repo.getCharacter();
        this.observableStats = repo.getCharacterStats();
        this.observableInfo = repo.getCharacterInfo();
    }

    public LiveData<PlayableCharacter> getObservableCharacter() {
        return observableCharacter;
    }

    public LiveData<PcStats> getObservableStats(){
        return observableStats;
    }

    public LiveData<PcInfo> getObservableInfo(){
        return observableInfo;
    }
}
