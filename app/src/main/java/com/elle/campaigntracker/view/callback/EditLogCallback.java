package com.elle.campaigntracker.view.callback;

import com.elle.campaigntracker.data.model.Log;

/**
 * Callback for adding/editing a Log
 */

public interface EditLogCallback {
    void onSave(Log log);
}
