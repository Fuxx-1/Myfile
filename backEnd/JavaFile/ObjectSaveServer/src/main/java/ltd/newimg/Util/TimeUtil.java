package ltd.newimg.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-16 15:13
 */
public class TimeUtil {

    /**
     * return the time after format
     *
     * @param date   the time you want
     * @param format the format you want, if null would be “EEE, dd MMM yyyy HH:mm:ss z”
     * @return
     */
    public static String transWithFormat(Date date, String format) throws Exception {
        // format判空并初始化format
        if (format == null || format.length() == 0) {
            format = "EEE, dd MMM yyyy HH:mm:ss z";
        }
        DateFormat ft = new SimpleDateFormat(format);
        // date判空及返回格式化后字符串
        if (date == null) {
            Exception DateNullException = new Exception();
            DateNullException.setStackTrace(new StackTraceElement[]{new StackTraceElement("TimeUtil", "transWithFormat", null, 32)});
            throw DateNullException;
        }
        return ft.format(date);
    }

    /**
     * get the current time
     *
     * @param format
     * @return String Time now
     */
    public static String getTime(String format) {
        String stringWithFormat = null;
        try {
            stringWithFormat = transWithFormat(new Date(), format);
        } catch (Exception e) {
            //忽略不可能出现的错误
        }
        return stringWithFormat;
    }

    /**
     * get the later time, you can specify the amount of delay
     *
     * @param format  the format you want
     * @param year    the year you want delay
     * @param month   the month you want delay
     * @param day     the day you want delay
     * @param hour    the hour you want delay
     * @param minutes the minutes you want delay
     * @param second  the second you want delay
     * @return String the time after delay
     */
    public static String getTimeAfter(String format, int year, int month, int day, int hour, int minutes, int second) {
        String stringWithFormat = null;
        // 初始化并设置calendar
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, year);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, day);
        calendar.add(Calendar.HOUR, hour);
        calendar.add(Calendar.MINUTE, minutes);
        calendar.add(Calendar.SECOND, second);
        // 格式化返回
        try {
            stringWithFormat = transWithFormat(calendar.getTime(), format);
        } catch (Exception e) {
            //忽略不可能出现的错误
        }
        return stringWithFormat;
    }
}
