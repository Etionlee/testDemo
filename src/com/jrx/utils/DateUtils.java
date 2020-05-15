package com.jrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.jrx.utils.ErrorConstants.*;

/**
 * 时间处理，时间日志工具类
 */
public class DateUtils
{

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private static DateFormat dateFormat;
    /**
     * 默认日期格式，yyyy-MM-dd
     */
    public static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 默认时间格式，HH:mm:ss
     */
    public static String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    /**
     * 默认日期时间格式，yyyy-MM-dd HH:mm:ss
     */
    public static String DEFAULT_DATETIME_PATTERN = DEFAULT_DATE_PATTERN + " " + DEFAULT_TIME_PATTERN;
    /**
     * 默认日期时间格式，yyyyMMdd
     */
    public static String DEFAULT_YEAR_PATTERN = "yyyyMMdd";

    /**
     * 默认日期时间格式，yyyyMMddHHmmss
     */
    public static final String SIMPLE_DATE_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String PATTERN_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";


    /**
     * 获取yyyyMMddHHmmssSSS格式的日期
     * 
     * @return 当前系统时间
     */
    public static final String getSysCurrentDataTime()
    {
        Date date = new Date();
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(PATTERN_YYYYMMDDHHMMSSSSS);
            return simpledateformat.format(date);
        }
        catch (Exception e)
        {
            logger.error("日期日期获取异常：", e);

            throw new DataRuntimeException(
                    ErrorUtils.errorText(ERROR_ACQUIRE_SYSTEM_DATE_FAIL_CODE, ERROR_ACQUIRE_SYSTEM_DATE_FAIL));
        }
    }


    /**
     * 获取yyyy格式的年份
     * 
     * @return 当前系统时间
     */
    public static final String getCurrentYear()
    {
        Date date = new Date();
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern("yyyy");
            return simpledateformat.format(date);
        }
        catch (Exception e)
        {
            logger.error("日期日期获取异常：", e);

            throw new DataRuntimeException(
                    ErrorUtils.errorText(ERROR_ACQUIRE_SYSTEM_DATE_FAIL_CODE, ERROR_ACQUIRE_SYSTEM_DATE_FAIL));
        }
    }


    /**
     * 获取yyyyMMddHHmmss格式的日期
     * 
     * @return 当前系统时间
     */
    public static final String getCurrentDataTimePure()
    {
        Date date = new Date();
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(SIMPLE_DATE_TIME_PATTERN);
            return simpledateformat.format(date);
        }
        catch (Exception e)
        {
            logger.error("日期日期获取异常：", e);

            throw new DataRuntimeException(
                    ErrorUtils.errorText(ERROR_ACQUIRE_SYSTEM_DATE_FAIL_CODE, ERROR_ACQUIRE_SYSTEM_DATE_FAIL));
        }
    }


    /**
     * 获取yyyy-MM-dd HH:mm:ss格式的日期
     * 
     * @return 当前系统时间
     */
    public static final String getCurrentDataTime()
    {
        Date date = new Date();
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(DEFAULT_DATETIME_PATTERN);
            return simpledateformat.format(date);
        }
        catch (Exception e)
        {
            logger.error("日期日期获取异常：", e);

            throw new DataRuntimeException(
                    ErrorUtils.errorText(ERROR_ACQUIRE_SYSTEM_DATE_FAIL_CODE, ERROR_ACQUIRE_SYSTEM_DATE_FAIL));
        }
    }


    /**
     * 获取yyyyMMdd格式的日期
     * 
     * @return 当前系统时间
     */
    public static final String getCurrentData()
    {
        Date date = new Date();
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(DEFAULT_YEAR_PATTERN);
            return simpledateformat.format(date);
        }
        catch (Exception e)
        {
            logger.error("时间日期获取异常：", e);

            throw new DataRuntimeException(
                    ErrorUtils.errorText(ERROR_ACQUIRE_SYSTEM_TIME_FAIL_CODE, ERROR_ACQUIRE_SYSTEM_TIME_FAIL));
        }
    }


    /**
     * 返回比当前天数多day天的那天日期，格式为yyyymmdd
     * 
     * @param day 增加天数
     * @return 当前系统时间+day天的时间
     */
    public static String getDate(int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        int iYear = cal.get(Calendar.YEAR);
        int iMonth = cal.get(Calendar.MONTH) + 1;
        int iDay = cal.get(Calendar.DAY_OF_MONTH);
        return "" + iYear + (iMonth < 10 ? "0" + iMonth : "" + iMonth) + (iDay < 10 ? "0" + iDay : "" + iDay);
    }


    /**
     * 返回比当前天数多day天的那天日期，格式为yyyymmdd，delimiter为年月日之间的分隔符
     * 
     * @param day 增加天数
     * @param delimiter 年月日间的分隔符
     * @return 当前系统时间+day天的时间，并用delimiter分隔后的日期
     */
    public static String getDate(int day, String delimiter)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        int iYear = cal.get(Calendar.YEAR);
        int iMonth = cal.get(Calendar.MONTH) + 1;
        int iDay = cal.get(Calendar.DAY_OF_MONTH);
        return "" + iYear + delimiter + (iMonth < 10 ? "0" + iMonth : "" + iMonth) + delimiter
                + (iDay < 10 ? "0" + iDay : "" + iDay);
    }


    /**
     * 将毫秒值转为日期，从1970-01-01 08:00:00开始
     * 
     * @param millis 毫秒值
     * @return 转换后的当前日期
     */
    public static final String millis2DateTime(long millis)
    {
        Date date = new Date(millis);
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat();
            simpledateformat.applyPattern(DEFAULT_DATETIME_PATTERN);
            return simpledateformat.format(date);
        }
        catch (Exception e)
        {
            logger.error("毫秒值转日期转换异常：", e);

            throw new DataRuntimeException(ErrorUtils.errorText(ERROR_MS_TO_DATE_FAIL_CODE, ERROR_MS_TO_DATE_FAIL));
        }
    }


    /**
     * 返回两个Date对象的之间的秒数
     * 
     * @param date1 作为被减数的Date对象
     * @param date2 作为减数的Date对象
     * @return int 两个Date对象的之间的秒数
     */
    public static int getSecondsTween(Date date1, Date date2)
    {
        long mill1 = date1.getTime();
        long mill2 = date2.getTime();
        return (int) ((mill1 - mill2) / (1000));
    }


    /**
     * 返回两个Date对象的之间的分钟数
     * 
     * @param date1 作为被减数的Date对象
     * @param date2 作为减数的Date对象
     * @return int 两个Date对象的之间的分钟数
     */
    public static int getMinutesTween(Date date1, Date date2)
    {
        long mill1 = date1.getTime();
        long mill2 = date2.getTime();
        return (int) ((mill1 - mill2) / (1000 * 60));
    }


    /**
     * 返回两个Date对象的之间的小时数
     * 
     * @param date1 作为被减数的Date对象
     * @param date2 作为减数的Date对象
     * @return int 两个Date对象的之间的小时数
     */
    public static int getHoursTween(Date date1, Date date2)
    {
        long mill1 = date1.getTime();
        long mill2 = date2.getTime();
        return (int) ((mill1 - mill2) / (1000 * 60 * 60));
    }


    /**
     * 返回两个Date对象的之间的天数
     * 
     * @param date1 作为被减数的Date对象
     * @param date2 作为减数的Date对象
     * @return int 两个Date对象的之间的天数
     */
    public static int getDaysTween(Date date1, Date date2)
    {
        long mill1 = date1.getTime();
        long mill2 = date2.getTime();
        return (int) ((mill1 - mill2) / (1000 * 60 * 60 * 24));
    }


    /**
     * 将字符串日期转换为Data日期
     * 
     * @param dateTime 所传日期
     * @return 返回Data类型，yyyy-MM-dd HH:mm:ss格式的日期
     * @throws ParseException 表示解析时出现意外错误。
     */
    public static Date getStandardDateTime(String dateTime) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME_PATTERN);
        return sdf.parse(dateTime);
    }


    /**
     * 返回两个Date对象的之间的秒数
     * 
     * @param date1 作为被减数的Date对象
     * @param date2 作为减数的Date对象
     * @return int 两个Date对象的之间的秒数
     */
    public static int getSecondsTween(String date1, String date2)
    {

        return (int) (getSecondsTweenMill(date1, date2) / (1000));
    }


    /**
     * 返回两个Date对象的之间的毫秒值
     * 
     * @param date1 作为被减数的Date对象
     * @param date2 作为减数的Date对象
     * @return int 两个Date对象的之间的秒数
     */
    public static int getSecondsTweenMill(String date1, String date2)
    {

        long mill1 = 0;
        long mill2 = 0;
        try
        {
            mill1 = getStandardDateTime(date1).getTime();
            mill2 = getStandardDateTime(date2).getTime();
        }
        catch (ParseException e)
        {
            logger.error("String转date转换异常：", e);

            throw new DataRuntimeException(
                    ErrorUtils.errorText(ERROR_STRING_TO_DATE_FAIL_CODE, ERROR_STRING_TO_DATE_FAIL));
        }
        return (int) ((mill2 - mill1));
    }


    public static String nowString(String pattern)
    {
        return getDateFormat(pattern).format(now());
    }


    public static DateFormat getDateFormat(String pattern)
    {
        if (pattern == null || "".equals(pattern.trim()))
        {
            pattern = DEFAULT_DATETIME_PATTERN;
        }
        dateFormat = new SimpleDateFormat(pattern);
        return dateFormat;
    }


    public static Date now()
    {
        return new Date();
    }


    public static Date getPreNMonth(Date date, int n)
    {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MONTH, 0 - n);
        return instance.getTime();
    }


    public static String getYYMMDD()
    {
        Date date = new Date();
        String dateString = "";
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_YEAR_PATTERN);
        try
        {
            dateString = sdf.format(date);
        }
        catch (Exception ex)
        {

        }
        return dateString;
    }


    public static String getCurrentMillisTime()
    {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssS");
        String strDate = df.format(now);
        return strDate;
    }


    public static int getDay(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }


    /**
     * 返回日期的月份，1-12,即yyyy-MM-dd中的MM
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 返回日期的年,即yyyy-MM-dd中的yyyy
     *
     * @param date Date
     * @return int
     */
    public static int getYear(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


    public static int getDaysOfMonth(int year, int month)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    public static int calDiffMonth(String startDate, String endDate)
    {
        int result = 0;
        try
        {
            SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMdd");
            Date start = sfd.parse(startDate);
            Date end = sfd.parse(endDate);
            int startYear = getYear(start);
            int startMonth = getMonth(start);
            int startDay = getDay(start);
            int endYear = getYear(end);
            int endMonth = getMonth(end);
            int endDay = getDay(end);
            if (startDay > endDay)
            { // 1月17 大于 2月28
                if (endDay == getDaysOfMonth(getYear(new Date()), 2))
                { // 也满足一月
                    result = (endYear - startYear) * 12 + endMonth - startMonth;
                }
                else
                {
                    result = (endYear - startYear) * 12 + endMonth - startMonth - 1;
                }
            }
            else
            {
                result = (endYear - startYear) * 12 + endMonth - startMonth;
            }

        }
        catch (ParseException e)
        {

        }

        return result;
    }


    public static String getYYYYMMDD()
    {
        Date date = new Date();
        String dateString = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try
        {
            dateString = sdf.format(date);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return dateString;
    }


    public static String getHHMMSS()
    {
        Date date = new Date();
        String dateString = "";
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        try
        {
            dateString = sdf.format(date);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return dateString;
    }


    public static void main(String[] args)
    {
        System.out.println(calDiffMonth("20171201", "20180531"));
    }
}
