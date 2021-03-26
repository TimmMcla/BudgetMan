package com.nedeveloper.billman.entities;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "expense")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private double amt;
    private Calendar dueDate;
    private Frequency dueFrequency;
    private float amtDuePercentage;
    private boolean amtRegularlyChanges;


    /**
     * Use this one for expenses that do not regularly change
     * @param name
     * @param amt
     * @param dueDate
     * @param dueFrequency
     */
    @Ignore
    public Expense(String name, double amt, Calendar dueDate, Frequency dueFrequency){

        this.name = name;
        this.amt = amt;
        this.dueDate = dueDate;
        this.dueFrequency= dueFrequency;
    }

    /**
     * Use this one for expenses that do regularly change
     * @param name
     * @param amt
     * @param dueDate
     * @param dueFrequency
     * @param amtRegularlyChanges
     * @param amtDuePercentage
     */
    public Expense(String name, double amt, Calendar dueDate, boolean amtRegularlyChanges, float amtDuePercentage , Frequency dueFrequency){
        this.name = name;
        this.amt = amt;
        this.dueDate = dueDate;
        this.dueFrequency = dueFrequency;
        this.amtRegularlyChanges = amtRegularlyChanges;
        this.amtDuePercentage = amtDuePercentage;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Frequency getDueFrequency() {
        return dueFrequency;
    }

    public void setDueFrequency(Frequency dueFrequency) {
        this.dueFrequency = dueFrequency;
    }

    public float getAmtDuePercentage() {
        return amtDuePercentage;
    }

    public void setAmtDuePercentage(float amtDuePercentage) {
        this.amtDuePercentage = amtDuePercentage;
    }

    public boolean isAmtRegularlyChanges() {
        return amtRegularlyChanges;
    }

    public void setAmtRegularlyChanges(boolean amtRegularlyChanges) {
        this.amtRegularlyChanges = amtRegularlyChanges;
    }
}
