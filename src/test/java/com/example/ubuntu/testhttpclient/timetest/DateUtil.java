package com.example.ubuntu.testhttpclient.timetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by  on 2017/9/2.
 */

public class DateUtil {

    /**
     * 1s==1000ms
     */
    private final static int TIME_MILLISECONDS = 1000;
    /**
     * 时间中的分、秒最大值均为60
     */
    private final static int TIME_NUMBERS = 60;
    /**
     * 时间中的小时最大值
     */
    private final static int TIME_HOURSES = 24;
    /**
     * 格式化日期的标准字符串
     */
    public final static String FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM = "yyyy-MM";
    public final static String SHORT_DATE_PATTERN_LINE = "yyyy-MM-dd";
    public final static String MM_DD = "MM-dd";
    public final static String DD_$_MM = "dd/MM";
    public final static String MM_dd_HH_MM = "MM-dd HH:mm";
    public final static String HH_MM = "HH:mm";
    public final static String HH_MM_SS = "HH:mm:ss";
    public final static String YYYY = "yyyy";
    public static final String MM = "MM";
    public final static String dd="dd";


    /**
     * 获取时区信息
     */
    public static TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    /**
     * 将日期字符串转换为Date对象
     *
     * @param date 日期字符串，必须为"yyyy-MM-dd HH:mm:ss"
     * @return 日期字符串的Date对象表达形式
     */
    public static Date parseDate(String date) {
        return parseDate(date, FORMAT);
    }

    /**
     * @param date 必须为"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static long parseLong(String date) {
        return parseDate(date).getTime();
    }

    /**
     * @param date 必须为"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static long parseLongGMT(String date) {
        return getCurrentTimeZoneUnixTime(parseDate(date).getTime());
    }


    /**
     * 将日期字符串转换为Date对象
     *
     * @param date   日期字符串，必须为"yyyy-MM-dd HH:mm:ss"
     * @param format 格式化字符串
     * @return 日期字符串的Date对象表达形式
     */
    public static Date parseDate(String date, String format) {
        Date dt = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            dt = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dt;
    }

    /**
     * 将Date对象转换为指定格式的字符串
     *
     * @param date Date对象
     * @return Date对象的字符串表达形式"yyyy-MM-dd HH:mm:ss"
     */
    public static String formatDate(Date date) {
        return formatDate(date, FORMAT);
    }

    /**
     * 将Date对象转换为指定格式的字符串
     *
     * @param date   Date对象
     * @param format String 格式化字符串
     * @return Date对象的字符串表达形式
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 格式化日期
     *
     * @param unixTime long unix时间戳         1513161633167
     * @return 日期字符串"yyyy-MM-dd HH:mm:ss"  2017-12-13 18:40:33
     */
    public static String formatUnixTime(long unixTime) {
        return formatUnixTime(unixTime, FORMAT);
    }

    /**
     * 格式化日期
     *
     * @param unixTime long unix时间戳
     * @param format   String 格式化字符串
     * @return 日期字符串
     */
    public static String formatUnixTime(long unixTime, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(unixTime);
    }

    /**
     * 将GMT日期格式化为系统默认时区的日期字符串表达形式
     *
     * @param gmtUnixTime GTM时间戳
     * @return 日期字符串"yyyy-MM-dd HH:mm:ss"
     */
    public static String formatGMTUnixTime(long gmtUnixTime) {
        return formatGMTUnixTime(gmtUnixTime, FORMAT);
    }

    /**
     * 将GMT日期格式化为系统默认时区的日期字符串表达形式
     *
     * @param gmtUnixTime GTM时间戳
     * @param format      格式化字符串
     * @return 日期字符串"yyyy-MM-dd HH:mm:ss"
     */
    public static String formatGMTUnixTime(long gmtUnixTime, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(gmtUnixTime + TimeZone.getDefault().getRawOffset());
    }

    /**
     * 获取时间戳的Date表示形式
     *
     * @param unixTime unix时间戳
     * @return Date对象
     */
    public static Date getDate(long unixTime) {
        return new Date(unixTime);
    }

    /**
     * 获取GMT时间戳的Date表示形式（转换为Date表示形式后，为系统默认时区下的时间）
     *
     * @param gmtUnixTime GMT Unix时间戳
     * @return Date对象
     */
    public static Date getGMTDate(long gmtUnixTime) {
        return new Date(gmtUnixTime + TimeZone.getDefault().getRawOffset());
    }

    /**
     * 将系统默认时区的Unix时间戳转换为GMT Unix时间戳
     *
     * @param unixTime unix时间戳
     * @return GMT Unix时间戳
     */
    public static long getGMTUnixTime(long unixTime) {
        return unixTime - TimeZone.getDefault().getRawOffset();
    }

    /**
     * 将GMT Unix时间戳转换为系统默认时区的Unix时间戳
     *
     * @param gmtUnixTime GMT Unix时间戳
     * @return 系统默认时区的Unix时间戳
     */
    public static long getCurrentTimeZoneUnixTime(long gmtUnixTime) {
        return gmtUnixTime + TimeZone.getDefault().getRawOffset();
    }

    /**
     * 获取当前时间的GMT Unix时间戳
     *
     * @return 当前的GMT Unix时间戳
     */
    public static long getGMTUnixTimeByCalendar() {
        Calendar calendar = Calendar.getInstance();
        // 获取当前时区下日期时间对应的时间戳
        long unixTime = calendar.getTimeInMillis();
        // 获取标准格林尼治时间下日期时间对应的时间戳
        long unixTimeGMT = unixTime - TimeZone.getDefault().getRawOffset();
        return unixTimeGMT;
    }

    /**
     * 获取当前时间的Unix时间戳
     *
     * @return 当前的Unix时间戳
     */
    public static long getUnixTimeByCalendar() {
        Calendar calendar = Calendar.getInstance();
        // 获取当前时区下日期时间对应的时间戳
        long unixTime = calendar.getTimeInMillis();
        return unixTime;
    }

    /**
     * 获取更改时区后的时间
     *
     * @param date    时间
     * @param oldZone 旧时区
     * @param newZone 新时区
     * @return 时间
     */
    public static Date changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
        Date dateTmp = null;
        if (date != null) {
            int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();
            dateTmp = new Date(date.getTime() - timeOffset);
        }
        return dateTmp;
    }

}
