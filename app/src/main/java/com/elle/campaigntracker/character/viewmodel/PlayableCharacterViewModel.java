package com.elle.campaigntracker.character.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;
import android.util.Log;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.character.PlayableCharacter;

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
        this.observableCharacter = repo.getCharacterLiveData();
    }

    public LiveData<PlayableCharacter> getObservableCharacter(){
        return observableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter){
        this.playableCharacter.set(playableCharacter);
    }

    public void updatePlayableCharacterHealth(int newHp){
        if(newHp > playableCharacter.get().getMaxHp()){
            newHp = playableCharacter.get().getMaxHp();
        }
        if(newHp < 0){
            newHp = 0;
        }
        Log.d("PCViewModel", "new health " + String.valueOf(newHp));
        playableCharacter.get().setCurrentHp(newHp);
        repo.updateCharacter(playableCharacter.get());
    }

    public void updatePlayableCharacterXp(int newXp){
        if(newXp > playableCharacter.get().getTotalXpToLevel()){
            newXp = playableCharacter.get().getTotalXpToLevel();
        }
        if(newXp < 0){
            newXp = 0;
        }
        Log.d("PCViewModel", "new XP " + String.valueOf(newXp));
        playableCharacter.get().setCurrentXp(newXp);
        repo.updateCharacter(playableCharacter.get());
    }

    //todo: update or insert
    public void updatePlayableCharacter(PlayableCharacter playableCharacter){
        repo.updateCharacter(playableCharacter);
    }
}
