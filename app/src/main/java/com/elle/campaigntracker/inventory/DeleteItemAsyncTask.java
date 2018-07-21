package com.elle.campaigntracker.inventory;

import android.os.AsyncTask;

import com.elle.campaigntracker.data.dao.ItemDao;
import com.elle.campaigntracker.inventory.Item;

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