//*****************************************************************************
//
// File Name       :  com.jrx.date.Date1
// Date Created    :  2020/3/2
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/3/2
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Etionlee on 2020/3/2.
 */
public class Date1
{
    public static void main(String[] args)
    {
        try
        {
            Date date = new SimpleDateFormat("yyyyMMdd").parse("20200320");
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
            System.out.println(dateStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
