package com.example.admin.datetimefunctions.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 21/09/2017.
 */

public class Utils
{

    public static String mTAG = "Utils";

    public static String dateFormat(String date, String format, String convertToFormat)
    {
        String new_date = "";

        try
        {
            SimpleDateFormat given_format = new SimpleDateFormat(format);
            Date given_date = given_format.parse(date);

            SimpleDateFormat new_format = new SimpleDateFormat(convertToFormat);
            new_date = new_format.format(given_date);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }

        return new_date;
    }

    public static String dateFormat(Date date, String format)
    {
        String new_date = "";

        try
        {
            SimpleDateFormat new_format = new SimpleDateFormat(format);
            new_date = new_format.format(date);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return new_date;
    }

    public static String getExpiryDate(int month, int year)
    {
        String expiry_date = "";
        String month_string = "";

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        String pattern = "MMMM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        int max_day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        if(month < 10)
            month_string = 0 + Integer.toString(month);
        else
            month_string = Integer.toString(month);

        expiry_date = Integer.toString(max_day) + "-" + month_string + "-" + Integer.toString(year);

        return expiry_date;
    }

    public static String getTime(String time)
    {
        String new_time = "";

        String[] given_time = time.split(":");
        String[] given_time_am_pm = given_time[1].split(" ");

        int hours = Integer.parseInt(given_time[0]);
        int minutes = Integer.parseInt(given_time_am_pm[0]);
        String am_pm_set = given_time_am_pm[1];

        if(am_pm_set.equalsIgnoreCase("pm"))
        {
            hours += 12;

            if(hours < 10)
                new_time = ("0" + Integer.toString(hours) + ":" + Integer.toString(minutes));
            else
                new_time = Integer.toString(hours) + ":" + Integer.toString(minutes);

            if(minutes < 10)
                new_time = Integer.toString(hours) + ":" + ("0" + Integer.toString(minutes));
            else
                new_time = Integer.toString(hours) + ":" + Integer.toString(minutes);
        }
        else if(am_pm_set.equalsIgnoreCase("am"))
        {
            if(hours == 12)
                hours = 0;

            if(hours < 10)
                new_time = ("0" + Integer.toString(hours) + ":" + Integer.toString(minutes));
            else
                new_time = Integer.toString(hours) + ":" + Integer.toString(minutes);

            if(minutes < 10)
                new_time = Integer.toString(hours) + ":" + ("0" + Integer.toString(minutes));
            else
                new_time = Integer.toString(hours) + ":" + Integer.toString(minutes);
        }
        return new_time;
    }

    public static String timeFormat(String time)
    {
        String new_time = "";
        String time_set = "";
        String hours_string = "", minutes_string = "";

        String[] given_time = time.split(":");

        int hours = Integer.parseInt(given_time[0]);
        int minutes = Integer.parseInt(given_time[1]);

        if(hours > 12)
        {
            hours -= 12;
            time_set = "pm";
        }
        else if(hours == 0)
        {
            hours += 12;
            time_set = "am";
        }
        else if(hours == 12)
        {
            time_set = "pm";
        }
        else
        {
            time_set = "am";
        }

        if(hours < 10)
            hours_string = 0 + Integer.toString(hours);
        else
            hours_string = Integer.toString(hours);

        if(minutes < 10)
            minutes_string = 0 + Integer.toString(minutes);
        else
            minutes_string = Integer.toString(minutes);

        new_time = hours_string + ":" + minutes_string + " " + time_set;

        return new_time;
    }

    public static String timeFormatWithSeconds(String time)
    {
        String new_time = "";
        String time_set = "";
        String hours_string = "", minutes_string = "", seconds_string = "";

        String[] given_time = time.split(":");

        int hours = Integer.parseInt(given_time[0]);
        int minutes = Integer.parseInt(given_time[1]);
        int seconds = Integer.parseInt(given_time[2]);

        if(hours > 12)
        {
            hours -= 12;
            time_set = "pm";
        }
        else if(hours == 0)
        {
            hours += 12;
            time_set = "am";
        }
        else if(hours == 12)
        {
            time_set = "pm";
        }
        else
        {
            time_set = "am";
        }

        if(hours < 10)
            hours_string = 0 + Integer.toString(hours);
        else
            hours_string = Integer.toString(hours);

        if(minutes < 10)
            minutes_string = 0 + Integer.toString(minutes);
        else
            minutes_string = Integer.toString(minutes);

        if(seconds < 10)
            seconds_string = 0 + Integer.toString(seconds);
        else
            seconds_string = Integer.toString(seconds);

        new_time = hours_string + ":" + minutes_string + ":" + seconds_string + " " + time_set;

        return new_time;
    }

}
