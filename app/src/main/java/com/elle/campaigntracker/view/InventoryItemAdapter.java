package com.elle.campaigntracker.view;

import android.arch.lifecycle.LiveData;
import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Recycler View Adapter for Inventory
 */

public class InventoryItemAdapter extends RecyclerView.Adapter<InventoryItemAdapter.ViewHolder> {
    private List<Item> itemList;

    public void setItemList(final List<Item> itemListIn){
        if(itemListIn != null){
            if(itemList == null){
                itemList = itemListIn;
                notifyItemRangeInserted(0, itemListIn.size());
            }else{
                DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                    @Override
                    public int getOldListSize() {
                        return itemList.size();
                    }

                    @Override
                    public int getNewListSize() {
                        return itemListIn.size();
                    }

                    @Override
                    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                        return itemList.get(oldItemPosition).getId() ==
                                itemListIn.get(newItemPosition).getId();
                    }

                    @Override
                    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                        Item newMessage = itemListIn.get(newItemPosition);
                        Item oldMessage = itemList.get(oldItemPosition);
                        return newMessage.getId() == oldMessage.getId()
                                && Objects.equals(newMessage.getDescription(), oldMessage.getDescription());
                    }
                });
                itemList = itemListIn;
                result.dispatchUpdatesTo(this);
                notifyItemInserted(itemListIn.size());
            }
        }else{
            itemList = new ArrayList<Item>();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setItem(itemList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(itemList == null){
            return 0;
        }
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ItemBinding binding;

        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
