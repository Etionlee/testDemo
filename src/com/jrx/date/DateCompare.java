//*****************************************************************************
//
// File Name       :  com.jrx.date.DateCompare
// Date Created    :  2020/3/30
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/3/30
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Etionlee on 2020/3/30.
 */
public class DateCompare
{
    public static void main(String[] args)
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");

            Date date1 = new Date();
            //date1.setHours(15);

            String a = format.format(date1);
            System.out.println(a);
            // Calendar cal1 = Calendar.getInstance();
            // cal1.set(Calendar.HOUR_OF_DAY, 15);
            // cal1.set(Calendar.MINUTE, 00);
            // cal1.set(Calendar.SECOND, 01);
            // Date date1 = cal1.getTime();

            // System.out.println(format.format(date1));

            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.HOUR_OF_DAY, 19);
            String b = format.format(cal2.getTime());

            // Date date2 = cal2.getTime();
            // System.out.println(format.format(date2));
            // System.out.println(format.format());
            System.out.println(b);
            System.out.println(a.compareTo(b));
            System.out.println(format.parse(a).compareTo(format.parse(b)));
            String str1 = "abc";
            String str2 = "IloveU";
            System.out.println(str1.compareTo(str2));
        }
        catch (Exception e)
        {

        }
    }
}
