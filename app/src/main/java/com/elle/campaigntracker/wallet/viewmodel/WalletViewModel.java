package com.elle.campaigntracker.wallet.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.elle.campaigntracker.wallet.Money;

public class WalletViewModel extends ViewModel {
    LiveData<Money> liveWallet;

    private WalletViewModel(Money money){

    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private Money money;

        public Factory(Money money) {
            this.money = money;
          //  mRepository = ((BasicApp) application).getRepository();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new WalletViewModel(money);
        }
    }
}
