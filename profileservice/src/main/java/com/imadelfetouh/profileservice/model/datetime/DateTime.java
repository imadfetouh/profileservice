package com.imadelfetouh.profileservice.model.datetime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTime {

    private static final DateTime dateTime = new DateTime();
    private TimeZone timeZone;

    private DateTime() {
        timeZone = TimeZone.getTimeZone("Europe/Amsterdam");
    }

    public static DateTime getInstance() {
        return dateTime;
    }

    public String timeStampToString(Long tweetDate) {
        Timestamp timestamp = new Timestamp(tweetDate * 1000L);
        Date date = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
    }
}
