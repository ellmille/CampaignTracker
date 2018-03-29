package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.PlayableCharacter;
import com.elle.campaigntracker.data.model.PcInfo;

/**
 * Callbacks for save buttons
 */

public interface SaveCallback {
    interface PcStats {
        void onSave(com.elle.campaigntracker.data.model.PcStats stats);
    }
    interface PcInfoSave {
        void onSave(PcInfo info);
    }
    interface PcBasics {
        void onSave(PlayableCharacter pc);
    }
}
