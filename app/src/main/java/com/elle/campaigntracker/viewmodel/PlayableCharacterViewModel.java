package com.elle.campaigntracker.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.elle.campaigntracker.data.DummyRepo;
import com.elle.campaigntracker.model.character.PlayableChar;

/**
 * Prepares data for the UI
 */

public class PlayableCharacterViewModel extends ViewModel {
    private MutableLiveData<PlayableChar> playableCharacter;

    public LiveData<PlayableChar> getPlayableCharacter(){
        if(playableCharacter == null){
            playableCharacter = new MutableLiveData<>();
            loadCharacter();
        }
        return playableCharacter;
    }

    private void loadCharacter() {
        //todo: get ID from last shared prefs
        DummyRepo dummyRepo = new DummyRepo();
        playableCharacter.setValue(dummyRepo.getPlayableChar());
    }
}
