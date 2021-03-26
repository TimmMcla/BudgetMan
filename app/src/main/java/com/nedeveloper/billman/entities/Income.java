package com.nedeveloper.billman.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "income")
public class Income {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String payType;
    private double amt;
    private Calendar payDate;
    private Frequency payFrequency;
    private float payChangePercentage;
    private boolean payRegularlyChanges;

    @Ignore
    public Income( String name, String payType, double amt, Calendar payDate, Frequency payFrequency){
        this.name = name;
        this.payType = payType;
        this.amt = amt;
        this.payDate = payDate;
        this.payFrequency = payFrequency;
    }

    public Income( String name, String payType, double amt, Calendar payDate, boolean payRegularlyChanges, float payChangePercentage,Frequency payFrequency){
        this.name = name;
        this.payType = payType;
        this.amt = amt;
        this.payDate = payDate;
        this.payFrequency = payFrequency;
        this.payRegularlyChanges = payRegularlyChanges;
        this.payChangePercentage = payChangePercentage;
    }



    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public Calendar getPayDate() {
        return payDate;
    }

    public void setPayDate(Calendar payDate) {
        this.payDate = payDate;
    }

    public Frequency getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(Frequency payFrequency) {
        this.payFrequency = payFrequency;
    }

    public float getPayChangePercentage() {
        return payChangePercentage;
    }

    public void setPayChangePercentage(float payChangePercentage) {
        this.payChangePercentage = payChangePercentage;
    }

    public boolean isPayRegularlyChanges() {
        return payRegularlyChanges;
    }

    public void setPayRegularlyChanges(boolean payRegularlyChanges) {
        this.payRegularlyChanges = payRegularlyChanges;
    }
}
