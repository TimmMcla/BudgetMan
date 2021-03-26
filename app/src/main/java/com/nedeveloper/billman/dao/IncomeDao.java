package com.nedeveloper.billman.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nedeveloper.billman.entities.Income;

import java.util.Calendar;
import java.util.List;

@Dao
public interface IncomeDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIncome(Income income);

    @Update
    void updateIncome(Income income);

    @Query("SELECT * FROM income WHERE payDate BETWEEN :now AND :payDateFuture")
    LiveData<List<Income>> getIncomeFromNowUntilNextPayDay(Calendar now, Calendar payDateFuture);

    @Query("SELECT * FROM income")
    LiveData<List<Income>> getAllIncomes();



}
