package com.nedeveloper.billman.room;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.nedeveloper.billman.dao.ExpenseDao;
import com.nedeveloper.billman.dao.IncomeDao;
import com.nedeveloper.billman.entities.Expense;
import com.nedeveloper.billman.entities.Frequency;
import com.nedeveloper.billman.entities.Income;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version = 0, entities = {Expense.class, Income.class}, exportSchema = false)
//@TypeConverters({CalendarObjectConverter.class})
public abstract class BudgetDatabase extends RoomDatabase {

    abstract ExpenseDao expenseDao();
    abstract IncomeDao incomeDao();

    private static volatile BudgetDatabase INSTANCE;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);

    static BudgetDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (BudgetDatabase.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BudgetDatabase.class, "db_budgetmanager")
                            .addCallback(populateDatabase)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback populateDatabase = new RoomDatabase.Callback(){
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            Calendar calendar = Calendar.getInstance();
            Expense expense = new Expense("Sample Bill",200.00,calendar, Frequency.Monthly);
            Income income = new Income("Sample Pay Day", "Bi-Weekly",300.00, calendar, Frequency.BiWeekly);

            databaseWriteExecutor.execute(() ->{
                ExpenseDao expenseDao = INSTANCE.expenseDao();
                IncomeDao incomeDao = INSTANCE.incomeDao();
                expenseDao.insertExpense(expense);
                incomeDao.insertIncome(income);
            });

        }

    };



}
