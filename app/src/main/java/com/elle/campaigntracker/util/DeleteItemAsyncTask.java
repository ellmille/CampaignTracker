package com.elle.campaigntracker.util;

import android.os.AsyncTask;

import com.elle.campaigntracker.data.dao.ItemDao;
import com.elle.campaigntracker.data.model.Item;

public class DeleteItemAsyncTask  extends AsyncTask<Item, Void, Void> {
    private ItemDao itemDao;

    public DeleteItemAsyncTask(ItemDao itemDao){
        this.itemDao = itemDao;
    }

    @Override
    protected Void doInBackground(Item... items) {
        itemDao.deleteItem(items[0]);
        return null;
    }
}