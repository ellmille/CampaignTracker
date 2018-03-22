package com.elle.campaigntracker.view;


import android.databinding.DataBindingUtil;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.databinding.FragmentAddItemBinding;
import com.elle.campaigntracker.view.callback.EditItemCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddItemFragment extends DialogFragment {
    FragmentAddItemBinding binding;
    //todo: pass in existing item if we are editing

    public AddItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_item, container, false);
        binding.setCallback(editItemCallback);
        //todo: pass in existing item if we are editing
        binding.setNewItem(new Item());
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private final EditItemCallback editItemCallback = new EditItemCallback() {
        @Override
        public void onSave(Item item) {
            Toast.makeText(getContext(), item.getName(), Toast.LENGTH_LONG).show();
            //todo: save to DB
        }
    };
}
