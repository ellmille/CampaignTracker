package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.CharacterSkills;
import com.elle.campaigntracker.data.model.CharacterInfo;
import com.elle.campaigntracker.data.model.PlayableCharacter;

/**
 * Callbacks for save buttons
 */

public interface SaveCallback {
    interface PcStatsSave {
        void onSave(CharacterSkills stats);
    }
    interface PcInfoSave {
        void onSave(CharacterInfo info);
    }
    interface PcSave {
        void onSave(PlayableCharacter playableCharacter);
    }

    interface MoneySave {
        void onSave(int amount);
    }
    interface XpSave {
        void onSave(int points);
    }
}
