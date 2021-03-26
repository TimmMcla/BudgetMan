package com.nedeveloper.billman.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.nedeveloper.billman.dao.ExpenseDao;
import com.nedeveloper.billman.dao.IncomeDao;
import com.nedeveloper.billman.entities.Expense;
import com.nedeveloper.billman.entities.Income;

import java.util.Calendar;
import java.util.List;

public class BudgetRepo {

    private ExpenseDao expenseDao;
    private IncomeDao incomeDao;

    public BudgetRepo(Application application){
        BudgetDatabase db = BudgetDatabase.getDatabase(application);
        expenseDao = db.expenseDao();
        incomeDao = db.incomeDao();
    }


    public void insertExpenseRecord(Expense expense){
        BudgetDatabase.databaseWriteExecutor.execute(()->{
            expenseDao.insertExpense(expense);
        });
    }

    public void insertIncomeRecord(Income income){
        BudgetDatabase.databaseWriteExecutor.execute(()->{
            incomeDao.insertIncome(income);
        });
    }

    public LiveData<List<Expense>> getAllExpenseRecords(){
        return expenseDao.getAllExpenses();
    }

    public LiveData<List<Income>> getAllIncomeRecords(){
        return incomeDao.getAllIncomes();
    }

    //Let's get it going to this point and then lets add some views composite keys and some specific queries
    /*
    public LiveData<List<Income>> getAllIncomeFromNowUntilDueDate(Calendar now, Calendar dueDate){
        return incomeDao.getIncomeFromNowUntilNextPayDay(now,dueDate);
    }
    */


}
