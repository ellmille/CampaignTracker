package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.Item;

/**
* Handles item clicks
 * */

public interface ItemCallback {
    void onItemClicked(Item item);
    void onFabClicked();
}
