package com.elle.campaigntracker.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.elle.campaigntracker.R;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Log;
import com.elle.campaigntracker.view.adapters.LogItemAdapter;
import com.elle.campaigntracker.viewmodel.InventoryViewModel;
import com.elle.campaigntracker.viewmodel.LogViewModel;

import java.util.List;

public class LogActivity extends AppCompatActivity {
    private LogViewModel viewModel;
    private LogItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
