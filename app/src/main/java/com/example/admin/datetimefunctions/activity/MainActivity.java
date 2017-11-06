package com.example.admin.datetimefunctions.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.datetimefunctions.R;
import com.example.admin.datetimefunctions.other.Utils;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    private String mTAG = "MainActivity";
    private String date_time = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date_time = Utils.dateFormat("22-09-2017", "dd-MM-yyyy", "dd MMM yyyy");
        Log.v(mTAG, "formatted string : " + date_time);

        Date date = Calendar.getInstance().getTime();
        date_time = Utils.dateFormat(date, "dd MMM yyyy");
        Log.v(mTAG, "formatted string : " + date_time);

        date_time = Utils.getExpiryDate(6, 2017);
        Log.v(mTAG, "formatted string : " + date_time);

        date_time = Utils.getTime("10:21 pm");
        Log.v(mTAG, "formatted string : " + date_time);

        date_time = Utils.timeFormat("18:30");
        Log.v(mTAG, "formatted string : " + date_time);

        date_time = Utils.timeFormatWithSeconds("0:51:45");
        Log.v(mTAG, "formatted string : " + date_time);

    }


}
