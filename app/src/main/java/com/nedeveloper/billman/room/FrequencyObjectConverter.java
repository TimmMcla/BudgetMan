package com.nedeveloper.billman.room;


import androidx.room.TypeConverter;

import com.nedeveloper.billman.entities.Frequency;

public class FrequencyObjectConverter {


    @TypeConverter
    public static String convertFromFrequency(Frequency frequency){
        return frequency.getFrequency();
    }

    @TypeConverter
    public static Frequency convertToFrequency(String frequency){
        for(Frequency frequencies : Frequency.values()){
            if(frequency.compareTo(frequencies.getFrequency())== 0){
                return frequencies;
            }
        }
        return null;
    }
}
