package com.elle.campaigntracker.inventory;

import android.os.AsyncTask;

import com.elle.campaigntracker.data.dao.ItemDao;
import com.elle.campaigntracker.inventory.Item;

public class InsertItemAsyncTask extends AsyncTask<Item, Void, Void> {
    private ItemDao itemDao;

    public InsertItemAsyncTask(ItemDao itemDao){
        this.itemDao = itemDao;
    }

    @Override
    protected Void doInBackground(Item... items) {
        itemDao.insertItem(items[0]);
        return null;
    }
}
