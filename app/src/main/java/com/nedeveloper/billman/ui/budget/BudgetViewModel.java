package com.nedeveloper.billman.ui.budget;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nedeveloper.billman.room.BudgetRepo;

public class BudgetViewModel extends ViewModel {

    private BudgetRepo budgetRepo;

    private MutableLiveData<String> mText;

    public BudgetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}