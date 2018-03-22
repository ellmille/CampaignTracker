package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.PlayableCharacter;

/**
 * Prepares data for the UI
 */

public class PlayableCharacterViewModel extends AndroidViewModel {
    private final LiveData<PlayableCharacter> observableCharacter;
    private final Repo repo;
    public ObservableField<PlayableCharacter> playableCharacter = new ObservableField<>();

    public PlayableCharacterViewModel(Application application){
        super(application);
        this.repo = ((App) application).getRepo();
        this.observableCharacter = repo.getCharacter();
    }

    public LiveData<PlayableCharacter> getObservableCharacter(){
        return observableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter){
        this.playableCharacter.set(playableCharacter);
    }
}
