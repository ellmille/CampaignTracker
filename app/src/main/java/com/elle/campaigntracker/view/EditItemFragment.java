package com.elle.campaigntracker.view;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.inventory.Item;
import com.elle.campaigntracker.databinding.FragmentAddItemBinding;
import com.elle.campaigntracker.inventory.ui.EditItemCallback;
import com.elle.campaigntracker.inventory.viewmodel.InventoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditItemFragment extends DialogFragment {
    FragmentAddItemBinding binding;

    public interface DialogItemCallback{
        void onSave(Item item);
        void onDelete(Item item);
    }

    DialogItemCallback listener;

    public EditItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_item, container, false);
        binding.setCallback(editItemCallback);
        if(getArguments().getBoolean(EditPcActivity.ARG_ACTION)){
            binding.setNewItem(new Item());
        }else{
            InventoryViewModel viewModel = ViewModelProviders.of(getActivity()).get(InventoryViewModel.class);
            if(viewModel.getItem() != null){
                binding.setNewItem(viewModel.getItem());
            }
        }
        //todo: pass in existing item if we are editing
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (DialogItemCallback) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    private final EditItemCallback editItemCallback = new EditItemCallback() {
        @Override
        public void onSave(Item item) {
            listener.onSave(item);
            dismiss();
        }

        @Override
        public void onDelete(Item item) {
            listener.onDelete(item);
            dismiss();
        }
    };
}
