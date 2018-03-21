package com.elle.campaigntracker.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.elle.campaigntracker.data.DummyRepo;
import com.elle.campaigntracker.data.model.PlayableCharacter;

/**
 * Prepares data for the UI
 */

public class PlayableCharacterViewModel extends ViewModel {
    private MutableLiveData<PlayableCharacter> playableCharacter;

    public LiveData<PlayableCharacter> getPlayableCharacter(){
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
