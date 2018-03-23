package com.elle.campaigntracker.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Log;
import com.elle.campaigntracker.databinding.ActivityLogBinding;
import com.elle.campaigntracker.view.adapters.LogItemAdapter;
import com.elle.campaigntracker.view.callback.FabCallback;
import com.elle.campaigntracker.viewmodel.InventoryViewModel;
import com.elle.campaigntracker.viewmodel.LogViewModel;

import java.util.List;

public class LogActivity extends AppCompatActivity {
    private LogViewModel viewModel;
    private LogItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLogBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_log);
        binding.setCallback(callback);

        RecyclerView recyclerView = findViewById(R.id.list);
        adapter = new LogItemAdapter();
        recyclerView.setAdapter(adapter);
        //set view model
        viewModel = ViewModelProviders.of(this).get(LogViewModel.class);
        viewModel.getObservableLogList().observe(this, new Observer<List<Log>>() {
            @Override
            public void onChanged(@Nullable List<Log> logs) {
                adapter.setLogList(logs);
            }
        });
    }

    private FabCallback callback = new FabCallback() {
        @Override
        public void onFabClicked() {
            Toast.makeText(LogActivity.this, "FAB", Toast.LENGTH_SHORT).show();
        }
    };
}
