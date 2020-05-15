//*****************************************************************************
//
// File Name       :  com.jrx.demo.DateDemo2
// Date Created    :  2019/10/10
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/10/10
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Etionlee on 2019/10/10.
 */
public class DateDemo2
{
    public static void main(String[] args) throws ParseException
    {

        // Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
        // ca.setTime(new Date(1562739899860l)); //设置时间为当前时间
        // ca.add(Calendar.DATE, -1); //年份减1
        // Date lastMonth = ca.getTime(); //结果
        // System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastMonth));

        Date businessDate = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-31");

        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(businessDate);
        Calendar cal = Calendar.getInstance();
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(5, 7);
        System.out.println("业务日期"+dateStr+";当期年份"+year+";当期月份"+month);
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month) + 1);
        cal.set(Calendar.DATE, 1);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        cal.add(Calendar.DATE, -1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        // System.out.println(getPreNDate(businessDate,1));
        // System.out.println(getPreNDate2(businessDate,1));


       // System.out.println(currMonth);


        // calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);// 月份更新

        // calendar.add(Calendar.DATE, -1);
        // System.out.println(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));

        //System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

    }


    /**
     * 获取指定日期的前n天日期
     *
     * @param date 格式：yyyy-MM-dd
     * @param n
     * @return
     */
    public static Date getPreNDate(Date date, int n)
    {
        try
        {
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
            Calendar cal = Calendar.getInstance();
            String year = dateStr.substring(0, 4);
            String month = dateStr.substring(5, 7);
            String day = dateStr.substring(8, 10);
            cal.set(Calendar.YEAR, Integer.parseInt(year));
            cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
            cal.set(Calendar.DATE, Integer.parseInt(day));
            cal.add(Calendar.DATE, 0 - n);

            return cal.getTime();

        }
        catch (Exception e)
        {
            throw new RuntimeException("进行日期运算时输入得参数不符合系统规格." + e);
        }
    }


    public static Date getPreNDate2(Date date, int n)
    {
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 0 - n);

            return cal.getTime();

        }
        catch (Exception e)
        {
            throw new RuntimeException("进行日期运算时输入得参数不符合系统规格." + e);
        }
    }


    /**
     * 获取指定日期的前n天日期
     *
     * @param date 格式：yyyy-MM-dd
     * @param n
     * @return
     */
    public static String getPreNDate(Date date, int n, String format)
    {
        try
        {
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
            Calendar cal = Calendar.getInstance();
            String year = dateStr.substring(0, 4);
            String month = dateStr.substring(5, 7);
            String day = dateStr.substring(8, 10);
            cal.set(Calendar.YEAR, Integer.parseInt(year));
            cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
            cal.set(Calendar.DATE, Integer.parseInt(day));
            cal.add(Calendar.DATE, 0 - n);
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(cal.getTime());

        }
        catch (Exception e)
        {
            throw new RuntimeException("进行日期运算时输入得参数不符合系统规格." + e);
        }
    }

}
