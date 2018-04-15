package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.PcInfo;
import com.elle.campaigntracker.data.model.PcStats;
import com.elle.campaigntracker.data.model.PlayableCharacter;

/**
 * Prepares data for the UI
 */

public class StatsViewModel extends AndroidViewModel {
    private final LiveData<PcStats> observableStats;
    private final Repo repo;
    public ObservableField<PcStats> pcStats = new ObservableField<>();

    public StatsViewModel(@NonNull Application application) {
        super(application);
        this.repo = ((App) application).getRepo();
        this.observableStats = repo.getCharacterStats();
    }

    public LiveData<PcStats> observableInfo() {
        return observableStats;
    }

    public void setPcInfo(PcStats pcStatsIn){
        this.pcStats.set(pcStatsIn);
    }
}

