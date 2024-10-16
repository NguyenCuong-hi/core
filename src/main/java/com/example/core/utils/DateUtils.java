package com.example.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.core.constans.DateConstants.NORMAL_DATE;

public class DateUtils {

    public static Date convertFromString (String date){
        SimpleDateFormat format = new SimpleDateFormat(NORMAL_DATE);
        Date parsed =  null;
        try{
            parsed = format.parse(date);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
        return new Date(parsed.getTime());
    }
}
