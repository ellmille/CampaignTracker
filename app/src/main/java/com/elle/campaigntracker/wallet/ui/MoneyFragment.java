package com.elle.campaigntracker.wallet.ui;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.inventory.ui.InventoryCallback;
import com.elle.campaigntracker.inventory.viewmodel.InventoryViewModel;
import com.elle.campaigntracker.wallet.Money;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment {
    private InventoryViewModel viewModel;
  //  private FragmentMoneyBinding binding;


    public MoneyFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(InventoryViewModel.class);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_money, container, false);
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_money, container, false);
//        binding.setCallback(moneyCallBack);
//        viewModel.getLiveMoney().observe(Objects.requireNonNull(getActivity()), new Observer<Money>() {
//            @Override
//            public void onChanged(@Nullable Money money) {
//                binding.setMoney(money);
//            }
//        });
//        return binding.getRoot();
    }

    private void openFragment(boolean isSpending){
        DialogFragment dialogFragment = new EditMoneyFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(EditMoneyFragment.ARG_IS_SPENDING, isSpending);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getChildFragmentManager(), EditMoneyFragment.TAG);
    }

    private InventoryCallback.MoneyCall moneyCallBack = new InventoryCallback.MoneyCall() {
        @Override
        public void onAdd() {
            openFragment(false);
        }

        @Override
        public void onSpend() {
            openFragment(true);
        }
    };
}
