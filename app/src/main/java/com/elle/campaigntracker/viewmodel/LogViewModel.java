package com.elle.campaigntracker.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.elle.campaigntracker.App;
import com.elle.campaigntracker.Repo;
import com.elle.campaigntracker.data.model.Item;
import com.elle.campaigntracker.data.model.Log;

import java.util.List;

/**
 * Prepares data for the UI
 */

public class LogViewModel extends AndroidViewModel {
    private final LiveData<List<Log>> observableLogList;
    public ObservableList<Log> logList;
    private final Repo repo;

    public LogViewModel(@NonNull Application application) {
        super(application);
        this.repo = ((App) application).getRepo();
        this.observableLogList = repo.getLogs();
    }

    public LiveData<List<Log>> getObservableLogList(){
        return observableLogList;
    }

    public void setLogList(List<Log> logs){
        this.logList.addAll(logs);
    }

    public void addLogToDb(Log logs){
        logs.setCharId(repo.getCharId());
        repo.addLog(logs);
    }
}
