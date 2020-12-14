package com.zyy.mowa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static Date now() {
        Date d = new Date();
        return d;
    }

    public static String nowString(String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        Date d = now();
        return fmt.format(d);
    }

    public static String nowString() {
        return nowString("yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDate(String timeString) {
        return toDate(timeString, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDateForDay(String timeString) {
        return toDate(timeString, "yyyy-MM-dd");
    }

    public static Date toDate(String timeString, String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        Date d;
        try {
            d = fmt.parse(timeString);
        } catch (ParseException e) {
            // throw new ParseRtException(String.format("%s 不匹配格式 %s", timeString,format),e);
            return null;
        }
        return d;
    }

    public static Date toDate(Date d1, String format) {
        String sDate = format(d1, format);
        return toDate(sDate, format);
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(date);
    }

    public static Date getDate(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime((Date)date.clone());
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        return ca.getTime();
    }

    public static Date addDays(Date d1, int days) {
        return addTime(d1, days, Calendar.DATE);
    }

    public static Date subDays(Date d1, int days) {
        return addTime(d1, -1 * days, Calendar.DATE);
    }

    public static Date addSeconds(Date d1, int seconds) {
        return addTime(d1, seconds, Calendar.SECOND);
    }

    public static Date subSeconds(Date d1, int seconds) {
        return addTime(d1, -1 * seconds, Calendar.SECOND);
    }

    public static Date addMinutes(Date d1, int mins) {
        return addTime(d1, mins, Calendar.MINUTE);
    }

    public static Date subMinutes(Date d1, int mins) {
        return addTime(d1, -1 * mins, Calendar.MINUTE);
    }

    public static Date addHalfhour(Date d1, int mins30) {
        return addTime(d1, mins30, Calendar.MINUTE);
    }

    public static Date subHalfhour(Date d1, int mins30) {
        return addTime(d1, -1 * mins30, Calendar.MINUTE);
    }

    public static Date addHours(Date d1, int hours) {
        return addTime(d1, hours, Calendar.HOUR_OF_DAY);
    }

    public static Date subHours(Date d1, int hours) {
        return addTime(d1, -1 * hours, Calendar.HOUR_OF_DAY);
    }

    public static Date addMonths(Date d1, int months) {
        return addTime(d1, months, Calendar.MONTH);
    }

    public static Date subMonths(Date d1, int months) {
        return addTime(d1, -1 * months, Calendar.MONTH);
    }

    public static Date addWeeks(Date d1, int weeks) {
        return addTime(d1, weeks, Calendar.WEEK_OF_YEAR);
    }

    public static Date subWeeks(Date d1, int weeks) {
        return addTime(d1, -1 * weeks, Calendar.WEEK_OF_YEAR);
    }

    private static Date addTime(Date d1, int val, int timePart) {
        Date d2 = (Date)d1.clone();
        Calendar ca = Calendar.getInstance();
        ca.setTime(d2);
        ca.add(timePart, val);
        return ca.getTime();
    }

    public static Date getDayInWeek(Date d1, int offset) {
        Date d2 = (Date)d1.clone();
        Calendar ca = Calendar.getInstance();
        ca.setTime(d2);

        int i = ca.get(Calendar.DAY_OF_WEEK);

        ca.add(Calendar.DAY_OF_YEAR, -1 * (i - 3 + offset));

        d2 = ca.getTime();

        return d2;
    }

    public static Date getDayInMonth(Date d1, int offset) {
        Date d2 = (Date)d1.clone();
        Calendar ca = Calendar.getInstance();
        ca.setTime(d2);

        int i = ca.get(Calendar.DAY_OF_MONTH);

        ca.add(Calendar.DAY_OF_YEAR, -1 * (i) + offset);

        d2 = ca.getTime();

        return d2;
    }

    /**
     * 计算两个时间之间相隔分钟
     * 
     * @param startday
     *            开始时间
     * @param endday
     *            结束时间
     * @return
     */
    public static int getIntervalMin(String startTime, String endTime) {

        Calendar stc1 = new GregorianCalendar();
        Date st = toDate(startTime);
        stc1.setTime(st);

        Calendar etc2 = new GregorianCalendar();
        Date et = toDate(endTime);
        etc2.setTime(et);

        // 确保startday在endday之前
        if (stc1.after(etc2)) {
            Calendar cal = stc1;
            stc1 = etc2;
            etc2 = cal;
        }
        // 分别得到两个时间的毫秒数
        long sl = stc1.getTimeInMillis();
        long el = etc2.getTimeInMillis();

        long ei = el - sl;
        // 根据毫秒数计算间隔天数
        return (int)(ei / (1000 * 60));
    }

}
