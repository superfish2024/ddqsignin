/**
 * Copyright 2015 Stnts Inc. All rights reserved. 
 * (注意：本内容仅限于盛天公司内部传阅，禁止外泄以及用于其他的商业目的) 
 * Date: 2015年10月29日 
 * 文件名称: DateUtil.java 
 * 项目名称: ecoin-intf 
 * 作者:Administrator
 **/
package com.tencent.wxcloudrun.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类,包括日期类型与字符串的转换，时间的计算等.
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 日期时间格式 yyyy-MM-dd HH:mm:ss.
     */
    public static final String FMT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间格式 yyyy-MM-dd HH:mm.
     */
    public static final String FMT_YMD_HM = "yyyy-MM-dd HH:mm";

    /**
     * 日期时间格式yyyyMMddHHmmss.
     */
    public static String FMT_DATETIME_COMPACT = "yyyyMMddHHmmss";

    /**
     * 日期时间格式 yyyy-MM-dd HH:mm.
     */
    public static final String FMT_YMD_HM_COMPACT = "yyyyMMddHHmm";

    /**
     * 日期格式yyyy-MM-dd.
     */
    public static String FMT_DATE = "yyyy-MM-dd";

    /**
     * 日期格式yyyyMMdd.
     */
    public static String FMT_DATE_COMPACT = "yyyyMMdd";

    /**
     * 时间格式 HH:mm:ss.
     */
    public static String FMT_TIME = "HH:mm:ss";

    /**
     * 时间格式HHmmss.
     */
    public static String FMT_TIME_COMPACT = "HHmmss";

    /**
     * 毫秒级时间格式HH:mm:ss:SSS.
     */
    public static String FMT_MILLITIME = "HH:mm:ss:SSS";

    /**
     * 毫秒级时间格式HHmmssSSS.
     */
    public static String FMT_MILLITIME_COMPACT = "HHmmssSS";

    /**
     * 毫秒级日期时间格式yyyy-MM-dd HH:mm:ss:SSS.
     */
    public static String FMT_MILLITDATETIME = "yyyy-MM-dd HH:mm:ss:SSS";

    /**
     * 毫秒级日期时间格式yyyyMMddHHmmssSS.
     */
    public static String FMT_MILLITDATETIME_COMPACT = "yyyyMMddHHmmssSSS";

    /**
     * 日期时间格式 MM-dd HH:mm:ss.
     */
    public static final String FMT_DATETIME_M = "MM-dd HH:mm";

    /**
     * 日期时间格式 MM-dd HH:mm:ss.
     */
    public static final String FMT_DATETIME_M_D = "MM-dd";
    public static final String FMT_DATETIME_M_D_S = "MM_dd";

    /**
     * 获取当前日期.
     *yyyy-MM-dd HH:mm:ss
     * @return Date类型
     */
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }



    /**
     * 转换日期yyyy-MM-dd
     * @param day
     * @return
     */
    public static Date getDay(String day) {
        SimpleDateFormat sdf = new SimpleDateFormat(FMT_DATE);
        Date date = null;
        try {
            date = sdf.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取格式化的当前日期时间.
     *
     * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
     */
    public static String getCurrentDateTimeStr() {
        return getCurrentDateTimeStr(FMT_DATETIME);
    }

    /**
     * 获取格式化的当前日期时间.
     *
     * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
     */
    public static String getCurrentDateTimeSSStr() {
        return getCurrentDateTimeStr(FMT_MILLITDATETIME_COMPACT);
    }


    /**
     * 获取格式化的当前日期时间.
     *
     * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
     */
    public static String getCurrentDateTimeMd() {
        return getCurrentDateTimeStr( FMT_DATETIME_M_D);
    }
    /**
     * 获取格式化的当前日期时间.
     *
     * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
     */
    public static String getCurrentDateTimeMds() {
        return getCurrentDateTimeStr( FMT_DATETIME_M_D_S);
    }
    /**
     * 获取格式化的当前日期时间.
     *
     * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD
     */
    public static String getCurrentDateTimeStrs() {
        return getCurrentDateTimeStr(FMT_DATE);
    }

    /**
     * 格式化当前日期时间.
     *
     * @param pattern 日期格式
     * @return 格式化后的当前日期时间
     */
    public static String getCurrentDateTimeStr(String pattern) {
        return dateToString(Calendar.getInstance().getTime(), pattern);
    }

    /**
     * 将日期转化为日期字符串。失败返回null.
     *
     * @param date 日期
     * @return 日期字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String dateToString(Date date) {
        return dateToString(date, FMT_DATETIME);
    }

    /**
     * 将日期转化为日期字符串。失败返回null.
     *
     * @param date 日期
     * @return 日期字符串 yyyy-MM-dd
     */
    public static String dateToStrings(Date date) {
        return dateToString(date, FMT_DATE);
    }

    /**
     * 将日期转化为日期字符串。失败返回null.
     *
     * @param date 日期
     * @return 日期字符串 yyyyMMdd
     */
    public static String dateToStrings2(Date date) {
        return dateToString(date, FMT_DATE_COMPACT);
    }

    /**
     * 将日期转化为日期字符串。失败返回null.
     *
     * @param date 日期
     * @param parttern 日期格式
     * @return 日期字符串
     */
    public static String dateToString(Date date, String parttern) {
        String dateString = null;
        if (date != null && StringUtils.isNotBlank(parttern)) {
            try {
                dateString = getDateFormat(parttern).format(date);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return dateString;
    }

    /**
     * 将日期字符串(yyyy-MM-dd HH:mm:ss)转化为日期。失败返回null.
     *
     * @param date 日期字符串
     * @return 日期
     */
    public static Date stringToDate(String date) {
        return stringToDate(date, FMT_DATETIME);
    }

    /**
     * 将日期字符串(yyyy-MM-dd)转化为日期。失败返回null.
     *
     * @param date 日期字符串
     * @return 日期
     */
    public static Date stringToDates(String date) {
        return stringToDate(date, FMT_DATE);
    }

    /**
     * 将字符串转化为日期。失败返回null.
     *
     * @param date 日期字符串
     * @param parttern 日期格式
     * @return 日期
     */
    public static Date stringToDate(String date, String parttern) {
        Date myDate = null;
        if (date != null && StringUtils.isNotBlank(parttern)) {
            try {
                myDate = getDateFormat(parttern).parse(date);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return myDate;
    }

    /**
     * 增加日期的年份。失败返回null.
     *
     * @param date 日期
     * @param yearAmount 增加数量。可为负数
     * @return 增加年份后的日期
     */
    public static Date addYear(Date date, int yearAmount) {
        return addDate(date, Calendar.YEAR, yearAmount);
    }

    /**
     * 增加日期的月份。失败返回null.
     *
     * @param date 日期
     * @param yearAmount 增加数量。可为负数
     * @return 增加月份后的日期
     */
    public static Date addMonth(Date date, int yearAmount) {
        return addDate(date, Calendar.MONTH, yearAmount);
    }



    /**
     * 增加日期的天数。失败返回null.
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加天数后的日期  yyyy-MM-dd
     */
    public static Date addDays(Date date, int dayAmount) {
        return addDates(date, Calendar.DATE, dayAmount);
    }

    /**
     * 减去日期的天数。失败返回null.
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加天数后的日期  yyyy-MM-dd
     */
    public static Date minusDay(String date, int dayAmount) {

        return minusDate(DateUtil.stringToDates(date), Calendar.DATE, dayAmount);
    }

    /**
     * 减去日期的天数。失败返回null.
     *
     * @param date 日期
     * @param dayAmount 减少数量。可为负数
     * @return 增加天数后的日期  yyyy-MM-dd HH:mm:ss
     */
    public static Date minusDay(Date date, int dayAmount) {
        return minusDate(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期的天数。失败返回null.
     *
     * @param date 日期
     * @param dayAmount 增加数量。可为负数
     * @return 增加天数后的日期  yyyy-MM-dd HH:mm:ss
     */
    public static Date addDay(Date date, int dayAmount) {
        return addDate(date, Calendar.DATE, dayAmount);
    }



    /**
     * 减去日期的小时。失败返回null.
     *
     * @param date 日期
     * @param dayAmount 减少数量。可为负数
     * @return 增加小时数后的日期  yyyy-MM-dd HH:mm:ss
     */
    public static Date minusHour(Date date, int dayAmount) {
        return minusDate(date, Calendar.HOUR_OF_DAY, dayAmount);
    }


    /**
     * 减去日期的分。失败返回null.
     *
     * @param date 日期
     * @param dayAmount 减少数量。可为负数
     * @return 增加小时数后的日期  yyyy-MM-dd HH:mm:ss
     */
    public static Date minusMinute(Date date, int dayAmount) {
        return minusDate(date, Calendar.MINUTE, dayAmount);
    }


    /**
     * 增加日期的小时。失败返回null.
     *
     * @param date 日期
     * @param hourAmount 增加数量。可为负数
     * @return 增加小时后的日期
     */
    public static Date addHour(Date date, int hourAmount) {
        return addDate(date, Calendar.HOUR_OF_DAY, hourAmount);
    }

    /**
     * 增加日期的分钟。失败返回null.
     *
     * @param date 日期
     * @param hourAmount 增加数量。可为负数
     * @return 增加分钟后的日期
     */
    public static Date addMinute(Date date, int hourAmount) {
        return addDate(date, Calendar.MINUTE, hourAmount);
    }

    /**
     * 增加日期的秒钟。失败返回null.
     *
     * @param date 日期
     * @param hourAmount 增加数量。可为负数
     * @return 增加秒钟后的日期
     */
    public static Date addSecond(Date date, int hourAmount) {
        return addDate(date, Calendar.SECOND, hourAmount);
    }

    /**
     * 获取日期的年份。失败返回0.
     *
     * @param date 日期
     * @return 年份
     */
    public static int getYear(Date date) {
        return getInteger(date, Calendar.YEAR);
    }

    /**
     * 获取日期的月份。失败返回0.
     *
     * @param date 日期
     * @return 月份
     */
    public static int getMonth(Date date) {
        return getInteger(date, Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的天数。失败返回0.
     *
     * @param date 日期
     * @return 天
     */
    public static int getDay(Date date) {
        return getInteger(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期的小时。失败返回0.
     *
     * @param date 日期
     * @return 小时数 (24小时制)
     */
    public static int getHour(Date date) {
        return getInteger(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取日期的分钟。失败返回0.
     *
     * @param date 日期
     * @return 分钟
     */
    public static int getMinute(Date date) {
        return getInteger(date, Calendar.MINUTE);
    }

    /**
     * 获取日期的秒钟。失败返回0.
     *
     * @param date 日期
     * @return 秒钟
     */
    public static int getSecond(Date date) {
        return getInteger(date, Calendar.SECOND);
    }

    /**
     * 获取日期的星期,星期天返回0.
     *
     * @param date 日期
     * @return 星期
     */
    public static int getWeek(Date date) {
        return getInteger(date, Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取星期的中文表示.
     *
     * @param date 日期
     * @return 星期
     */
    public static String getWeekCn(Date date) {
        String weekString = "";
        final String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int dayOfWeek = getInteger(date, Calendar.DAY_OF_WEEK);
        weekString = dayNames[dayOfWeek - 1];
        return weekString;
    }

    /**
     * 根据年月日得到日期.
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 日期
     */
    public static Date getDate(int year, int month, int day) {
        return getDate(year, month, day, 0, 0, 0);
    }

    /**
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hourOfDay 时 (24小时制)
     * @param minute 分
     * @param second 秒
     * @return 日期
     */
    public static Date getDate(int year, int month, int day, int hourOfDay, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month + 1, day, hourOfDay, minute, second);
        return calendar.getTime();
    }


    /**
     * 比较两个日期大小.(相差天数)
     *
     * @param time1 日期
     * @param time2 日期
     * @return 整数 正数：time1 > time2 ， 负数:time1 < time2, 0: time1 = time2
     */
    public static long diffDate(Date time1, Date time2) {
        return (int) ((getMillis(time1) - getMillis(time2)) / (24 * 3600 * 1000));
    }
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 比较两个日期大小.
     *
     * @param time1 日期
     * @param time2 日期
     * @return 整数 正数：time1 > time2 ， 负数:time1 < time2, 0: time1 = time2
     */
    public static long compareDate(Date time1, Date time2) {
        if (time1 == null) {
            if (time2 == null) {
                return 0;
            } else {
                return -1;
            }
        } else if (time2 == null) {
            return 1;
        } else {
            return new Long(time1.getTime() - time2.getTime());
        }
    }

    /**
     * 比较两个日期大小.
     *
     * @param time1 日期
     * @param time2 日期
     * @param pattern 比较日期格式，例如:比较年月日 yyyy-MM-dd， 比较时间 HH:mm:ss
     * @return 整数 正数：time1 > time2 ， 负数:time1 < time2, 0: time1 = time2
     */
    public static long compareDate(Date time1, Date time2, String pattern) {
        // 有效性检查
        if (time1 == null) {
            if (time2 == null) {
                return 0;
            } else {
                return -1;
            }
        } else if (time2 == null) {
            return 1;
        } else {
            String time1Str = dateToString(time1, pattern);
            String time2Str = dateToString(time2, pattern);
            if (StringUtils.isBlank(pattern) || time1Str == null || time2Str == null) {
                return new Long(time1.getTime() - time2.getTime()).intValue();
            }
            return compareDate(stringToDate(time1Str, pattern), stringToDate(time2Str, pattern));
        }
    }

    /**
     * 判断日期是否在开始时间与结束时间之间.
     *
     * @param date 时间
     * @param start 开始时间
     * @param end 结束时间
     * @return boolean
     */
    public static boolean isWithinRange(Date date, Date start, Date end) {
        if (date != null && start != null && end != null && compareDate(date, start) >= 0 && compareDate(date, end) <= 0) {
            return true;
        }
        return false;
    }

    /**
     * @function 判断两个时间戳是否属于同一天 boolean
     */
    public static boolean isTheSameDate(long time1, long time2) {
        Timestamp timestamp1 = new Timestamp(time1);
        Timestamp timestamp2 = new Timestamp(time2);
        if (timestamp1 != null && timestamp2 != null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(timestamp1);
            int y1 = c1.get(Calendar.YEAR);
            int m1 = c1.get(Calendar.MONTH);
            int d1 = c1.get(Calendar.DATE);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(timestamp2);
            int y2 = c2.get(Calendar.YEAR);
            int m2 = c2.get(Calendar.MONTH);
            int d2 = c2.get(Calendar.DATE);
            if (y1 == y2 && m1 == m2 && d1 == d2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static SimpleDateFormat getDateFormat(String parttern) {
        return new SimpleDateFormat(parttern);
    }


    /**
     * 增加日期中某类型的某数值。如增加日期.
     *
     * @param date 日期
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期    yyyy-MM-dd
     */
    private static Date addDates(Date date, int dateType, int amount) {
        Date myDate = null;
        try {
            if (date != null) {
                SimpleDateFormat format = new SimpleDateFormat(FMT_DATE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(dateType, amount);
                myDate = calendar.getTime();
                myDate = format.parse(format.format(myDate));

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return myDate;
        }

    }
    /**
     * 增加日期中某类型的某数值。如增加日期.
     *
     * @param date 日期
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期    yyyy-MM-dd HH:mm:ss
     */
    private static Date addDate(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }


    /**
     * 减去日期中某类型的某数值。如减去日期.
     *
     * @param date 日期
     * @param dateType 类型
     * @param amount 数值
     * @return 计算后日期    yyyy-MM-dd HH:mm:ss
     */
    private static Date minusDate(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, -amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**
     * 获取日期中的某数值。如获取月份.
     *
     * @param date 日期
     * @param dateType 日期格式
     * @return 数值
     */
    private static int getInteger(Date date, int dateType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(dateType);
    }

    /**
     * long型日期转日期字符串.
     *
     * @param time
     * @param parttern
     * @return
     */
    public static String longDateToString(long time, String parttern) {
        SimpleDateFormat format = new SimpleDateFormat(parttern);
        Date date = new Date(time);
        return format.format(date);
    }

    /**
     * 获取每月第一天.
     *
     * @param parttern
     * @return
     */
    public static String getFirstDay(String parttern, int index) {
        SimpleDateFormat format = new SimpleDateFormat(parttern);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, index);
        c.set(Calendar.DAY_OF_MONTH, 1);
        // 设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        return first;
    }

    /**
     * 获取每月最后一天.
     *
     * @param parttern
     * @return
     */
    public static String getLastDay(String parttern, int index) {
        SimpleDateFormat format = new SimpleDateFormat(parttern);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, index);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        return last;
    }

    /**
     * 获取某一天的日期.
     *
     * @param parttern
     * @return
     */
    public static String getDay(String parttern, int index) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, index);
        Date d = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat(parttern);
        return sp.format(d);
    }

    public static List<String> getXdays(int m) {
        List<String> dateList = new ArrayList<String>();
        for (int i = m; i >= 0; i--) {
            Date dBefore = new Date();
            Calendar calendar = Calendar.getInstance(); // 得到日历
            calendar.add(Calendar.DAY_OF_MONTH, -i); // 设置为前某天
            dBefore = calendar.getTime(); // 得到前一天的时间

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
            String defaultStartDate = sdf.format(dBefore); // 格式化前一天
            dateList.add(defaultStartDate);
        }
        return dateList;
    }

    /**
     * 获取时间区间内的所有天数
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static List<String> getBetweenDays(String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startD = sdf.parse(start);
        Date endD = sdf.parse(end);
        double between = (endD.getTime() - startD.getTime()) / 1000;
        // 除以1000是为了转换成秒
        double day = between / (24 * 3600) + 1;

        List<String> daysList = new ArrayList<String>();
        for (int i = 1; i <= day; i++) {

            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(start));
            cd.add(Calendar.DATE, i - 1);
            // 增加一天
            daysList.add(sdf.format(cd.getTime()));
        }

        return daysList;

    }

    /**
     * 获取时间区间内的天数
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static long daysBetween(String start, String end)  {
        long between_days = 0L;
        try {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startD = sdf.parse(start);
        Date endD = sdf.parse(end);
        between_days=(endD.getTime()-startD.getTime())/(1000*3600*24);

        }catch (Exception e){

        }finally {
            return between_days;
        }

    }
    /**
     * 获取昨日时间 格式 yyyy-MM-dd.
     *
     * @return
     */
    public static String getYesterdayStr() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return yesterday;
    }

    /**
     * 时间类型转字符串
     * @param date
     * @return yyyy:MM:dd HH:mm:ss
     */
    public static String DateToStr(Date date){
        SimpleDateFormat sFormat=new SimpleDateFormat(FMT_DATETIME);
        return sFormat.format(date);
    }

    /**
     * 时间类型转字符串
     * @param date
     * @param format 模板
     * @return
     */
    public static String DateToStr(Date date , String format){
        SimpleDateFormat sFormat=new SimpleDateFormat(format);
        return sFormat.format(date);
    }
    /**
     * 字符串转时间类型
     * @param dateStr
     * @return yyyy:MM:dd HH:mm:ss
     */
    public static Date StrToDate(String dateStr) {
        Date date=new Date();
        SimpleDateFormat sFormat=new SimpleDateFormat(FMT_DATETIME);
        try {
            date = sFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            date=new Date();
        }
        return date;
    }

    /**
     * 字符串转时间类型
     * @param dateStr
     * @return yyyy:MM:dd
     */
    public static Date StrToDates(String dateStr) {
        Date date=new Date();
        SimpleDateFormat sFormat=new SimpleDateFormat(FMT_DATE);
        try {
            date = sFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            date=new Date();
        }
        return date;
    }

    /**
     * 获取年月日时间字符串
     * @return
     */
    public static String GetYearMonthDay(){
        Calendar now = Calendar.getInstance();
        String year="";
        String month="";
        String day="";
        year=now.get(Calendar.YEAR)+"";
        month=now.get(Calendar.MONTH) + 1+"";
        day=now.get(Calendar.DATE)+"";
        if((now.get(Calendar.MONTH) + 1)<10){
            month="0"+(now.get(Calendar.MONTH) + 1);
        }
        if(now.get(Calendar.DATE)<10){
            day="0"+now.get(Calendar.DATE);
        }

        String yearMonthDayStr=year+month+day;
        return yearMonthDayStr;
    }


    /**
     * 获取年月日时分秒毫秒时间字符串
     * @return
     */
    public static String GetAllTimeStr(){
        Calendar now = Calendar.getInstance();
        String yearMonthDayStr= String.valueOf(now.get(Calendar.YEAR))+ String.valueOf((now.get(Calendar.MONTH) + 1))+ String.valueOf(now.get(Calendar.DAY_OF_MONTH))+
                String.valueOf(now.get(Calendar.HOUR_OF_DAY))+ String.valueOf(now.get(Calendar.MINUTE))+ String.valueOf(now.get(Calendar.SECOND));
        return yearMonthDayStr;
    }



    public static void main(String[] args) throws Exception {
//        GetYearMonthDay();
//
//        List<String>  list=  getBetweenDays("2017-09-11","2017-09-11");
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }


//        System.out.println(daysBetween("2017-09-11","2017-09-20"));
          System.out.println(DateUtil.getWeek(new Date()));
    }


}
