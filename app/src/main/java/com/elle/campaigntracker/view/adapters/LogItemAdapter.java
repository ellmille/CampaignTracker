package com.elle.campaigntracker.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Log;
import com.elle.campaigntracker.databinding.LogItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Recycler View Adapter for Logs
 */

public class LogItemAdapter extends RecyclerView.Adapter<LogItemAdapter.ViewHolder>{
    private List<Log> logList;

    public void setLogList(final List<Log> logListIn){
        if(logListIn != null){
            if(logList == null){
                logList = logListIn;
                notifyItemRangeInserted(0, logListIn.size());
            }else{
                DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                    @Override
                    public int getOldListSize() {
                        return logList.size();
                    }

                    @Override
                    public int getNewListSize() {
                        return logListIn.size();
                    }

                    @Override
                    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                        return logList.get(oldItemPosition).getId() ==
                                logListIn.get(newItemPosition).getId();
                    }

                    @Override
                    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                        Log newLog = logListIn.get(newItemPosition);
                        Log oldLog = logList.get(oldItemPosition);
                        return newLog.getId() == oldLog.getId()
                                && Objects.equals(newLog.getLogEntry(), oldLog.getLogEntry());
                    }
                });
                logList = logListIn;
                result.dispatchUpdatesTo(this);
                notifyItemInserted(logListIn.size());
            }
        }else{
            logList = new ArrayList<Log>();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.log_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setLog(logList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(logList == null){
            return 0;
        }
        return logList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final LogItemBinding binding;

        ViewHolder(LogItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
