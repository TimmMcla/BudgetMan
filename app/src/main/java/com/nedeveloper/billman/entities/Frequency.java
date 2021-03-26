package com.nedeveloper.billman.entities;

public enum Frequency {
    Weekly("Weekly"),
    BiWeekly("Bi-Weekly"),
    Monthly("Monthly"),
    SemiAnnually("Semi-Annual"),
    Annually("Annual");
    private final String frequency;
    Frequency(final String frequency){
        this.frequency = frequency;
    }
    public String getFrequency(){
        return this.frequency;
    }

}
