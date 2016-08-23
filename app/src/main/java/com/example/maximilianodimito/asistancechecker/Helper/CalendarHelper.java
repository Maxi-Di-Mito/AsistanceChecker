package com.example.maximilianodimito.asistancechecker.helper;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by maximiliano.dimito on 8/19/2016.
 */
public final class CalendarHelper {

    public static String getMonthName(Date d)
    {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTime(d);
        int m = cal.get(Calendar.MONTH);
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.getDefault());
        return dfs.getMonths()[m];
    }

}
