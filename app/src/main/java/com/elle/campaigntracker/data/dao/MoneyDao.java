package com.elle.campaigntracker.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.elle.campaigntracker.wallet.Money;

/**
 * Methods for accessing the database
 */

@Dao
public interface MoneyDao {
    @Query("SELECT * FROM Money WHERE character_id=:charId")
    LiveData<Money> getMoneyByCharId(int charId);

    @Insert
    void insertMoney(Money money);

    @Update
    void updateMoney(Money money);
}
