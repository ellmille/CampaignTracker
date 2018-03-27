package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.PlayableCharacterInfo;
import com.elle.campaigntracker.data.model.PlayableCharacterStats;

/**
 * Callbacks for save buttons
 */

public interface SaveCallback {
    interface PcStats {
        void onSave(PlayableCharacterStats stats);
    }
    interface PcInfoSave {
        void onSave(PlayableCharacterInfo info);
    }
    interface PcBasics {
        void onSave(PlayableCharacter pc);
    }
}
