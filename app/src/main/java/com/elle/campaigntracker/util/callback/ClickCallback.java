package com.elle.campaigntracker.util.callback;

import com.elle.campaigntracker.inventory.Item;
import com.elle.campaigntracker.data.model.world.Log;

/**
 * Contains callbacks for list clicks
 */

public interface ClickCallback {
    interface ItemClick {
        void onClick(Item item);
    }
    interface LogClick {
        void onClick(Log log);
    }
}
