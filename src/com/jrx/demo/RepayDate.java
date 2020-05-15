//*****************************************************************************
//
// File Name       :  com.jrx.demo.RepayDate
// Date Created    :  2019/10/30
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/10/30
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
 * Created by Etionlee on 2019/10/30.
 */
public class RepayDate
{

    public static void main(String[] args) throws ParseException
    {
        Date businessDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-29");
        Date computeDate = computeDateByTenorTxn(businessDate, 1, 30);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(computeDate.getTime()));
    }


    /**
     * 对应日还款日计算
     *
     * @param date 首期还款日
     * @param tenor 需要增加的月份数
     * @param cycle 还款日
     * @return
     */
    public static Date computeDateByTenor(Date date, int tenor, int cycle)
    {
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Calendar cal = Calendar.getInstance();
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(5, 7);
        System.out.println("-------第" + tenor + "期还款日计算，首次还款日" + dateStr);
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month) + tenor);
        cal.set(Calendar.DATE, 1);

        // System.out.println("-------第"+tenor+"期还款日计算，下下月1号日期"+new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())
        // );
        cal.add(Calendar.DATE, -1);
        System.out.println("-------第" + tenor + "期还款日计算，日期" + new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        System.out.println("-------第" + tenor + "期还款日计算，最后一天为" + cal.get(Calendar.DAY_OF_MONTH));

        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        // 下月对应日存在
        if (dayOfMonth >= cycle)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + tenor);// 月份更新
            return calendar.getTime();
        }
        // 下月对应日不存在，取下月最后一天
        else
        {
            return cal.getTime();
        }

    }


    /**
     * 对应日还款日计算
     *
     * @param date 首期还款日
     * @param tenor 需要增加的月份数
     * @param cycle 还款日
     * @return
     */
    public static Date computeDateByTenorTxn(Date date, int tenor, int cycle)
    {
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Calendar cal = Calendar.getInstance();
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(5, 7);
        System.out.println("-------第" + tenor + "期还款日计算，当前业务日期" + dateStr);
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month) + tenor);
        cal.set(Calendar.DATE, 1);

        // logger.info("-------第{}期还款日计算，下下月1号日期{}", tenor, new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        cal.add(Calendar.DATE, -1);
        // logger.info("-------第{}期还款日计算，日期为{}", tenor, new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        // logger.info("-------第{}期还款日计算，最后一天为{}", tenor, cal.get(Calendar.DAY_OF_MONTH));

        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        // 下月对应日存在
        if (dayOfMonth >= cycle)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + tenor);
            System.out.println("-------第" + tenor + "期还款日计算，该期次最后一天为" + dayOfMonth + "，对应日存在，使用还款日"
                    + new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            return calendar.getTime();
        }
        // 下月对应日不存在，取下月最后一天
        else
        {
            System.out.println("-------第" + tenor + "期还款日计算，该期次最后一天为" + dayOfMonth + "，对应日不存在，使用还款日"
                    + new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
            return cal.getTime();
        }

    }
}