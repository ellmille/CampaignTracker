package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.Money;
import com.elle.campaigntracker.data.model.PcStats;
import com.elle.campaigntracker.data.model.PcInfo;

/**
 * Callbacks for save buttons
 */

public interface SaveCallback {
    interface PcStatsSave {
        void onSave(PcStats stats);
    }
    interface PcInfoSave {
        void onSave(PcInfo info);
    }
    interface PcSave {
        void onSave(PlayableCharacter pc);
    }

    interface MoneySave {
        void onSave(Money money);
    }
}
