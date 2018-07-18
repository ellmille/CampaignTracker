package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.CharacterSkills;

/**
 * Prepares data for the UI
 */

public class StatsViewModel extends AndroidViewModel {
    private final LiveData<CharacterSkills> observableStats;
    private final Repo repo;
    public ObservableField<CharacterSkills> pcStats = new ObservableField<>();

    public StatsViewModel(@NonNull Application application) {
        super(application);
        this.repo = ((App) application).getRepo();
        this.observableStats = repo.getCharacterStats();
    }

    public LiveData<CharacterSkills> observableInfo() {
        return observableStats;
    }

    public void setPcInfo(CharacterSkills characterSkillsIn){
        this.pcStats.set(characterSkillsIn);
    }
}

