package com.elle.campaigntracker.view;

/**
 * Contract between view and presenter
 */

public interface MainActivityContract {
    interface Presenter {
        void onShowCharacter();
    }
    interface View {
        void showCharacter();
    }
}
