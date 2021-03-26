package com.nedeveloper.billman.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nedeveloper.billman.entities.Expense;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExpense(Expense expense);

    @Update
    void updateExpense(Expense expense);

    @Query("SELECT * FROM expense")
    LiveData<List<Expense>> getAllExpenses();


}
