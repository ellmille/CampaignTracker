package com.elle.campaigntracker.view;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.adapters.SpinnerBindingAdapter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.databinding.FragmentEditMoneyBinding;
import com.elle.campaigntracker.view.callback.EditItemCallback;
import com.elle.campaigntracker.view.callback.SaveCallback;

/**
 * A {@link DialogFragment} to change money amount.
 */
public class EditMoneyFragment extends DialogFragment {
    public static final String TAG = "MONEY";
    public static final String ARG_IS_SPENDING = "SPENDING";
    private String type;

    public interface DialogMoneyCallback{
        void onSaveMoney(int amount, String type);
    }

    DialogMoneyCallback listener;

    public EditMoneyFragment() {
        // Required empty public constructor
    }

    //todo: setup spinner
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentEditMoneyBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_money, container, false);
        //todo: setup double data binding with spinner
        Spinner spinner = binding.getRoot().findViewById(R.id.type);
        spinner.setOnItemClickListener(selectedListener);
        binding.setCallback(moneyCallback);
        binding.setIsSpending(getArguments().getBoolean(ARG_IS_SPENDING));
        binding.setAmount(10);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private SaveCallback.MoneySave moneyCallback = new SaveCallback.MoneySave() {
        @Override
        public void onSave(int amount) {
            System.out.println(String.valueOf(amount));
            listener.onSaveMoney(amount, type);
        }
    };

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (DialogMoneyCallback) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    AdapterView.OnItemClickListener selectedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            type = parent.getItemAtPosition(position).toString();
        }
    };
}
