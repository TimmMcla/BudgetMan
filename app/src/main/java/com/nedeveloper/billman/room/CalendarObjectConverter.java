package com.nedeveloper.billman.room;


import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/*
public class CalendarObjectConverter {

    private static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);

    @TypeConverter
    public static String convertToString(Calendar calendar) {
        if(calendar != null){
            try{
                return dateFormat.format(calendar.getTime());
            } catch (Exception e){
                return null;
            }
        }
        return null;
    }

    @TypeConverter
    public static String convertFromCalendar( Calendar calendar){
        return dateFormat.format(calendar.getTime());
    }

}
*/