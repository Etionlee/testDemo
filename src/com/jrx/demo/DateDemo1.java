//*****************************************************************************
//
// File Name       :  com.jrx.demo.DateDemo1
// Date Created    :  2019/6/25
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/6/25
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

/**
 * Created by Etionlee on 2019/6/25.
 */
public class DateDemo1
{
    public static void main(String[] args) throws ParseException
    {
        String date = "2019-12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println( sdf1.parse(date));
    }
}
