//*****************************************************************************
//
// File Name       :  com.jrx.date.TimeDemo1
// Date Created    :  2020/4/14
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/4/14
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Etionlee on 2020/4/14.
 */
public class TimeDemo1
{
    public static void main(String[] args) throws ParseException
    {
        Date paymentDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-19");
        Date businessDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-20");
        int days = computeDateDiff(paymentDate, businessDate);
        System.out.println(days);
    }
    public static int computeDateDiff(Date t_start, Date t_end)
    {
        int i = (int) ((t_end.getTime() - t_start.getTime()) / 86400000);
        return i;
    }
}

