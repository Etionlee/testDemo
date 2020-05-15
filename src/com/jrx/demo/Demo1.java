//*****************************************************************************
//
// File Name       :  com.jrx.demo.Demo1
// Date Created    :  2018/9/17
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2018/9/17
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2018.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Etionlee on 2018/9/17.
 */
public class Demo1
{

    public static void main(String[] args) throws ParseException
    {
        Date d=new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US).parse("Sat Nov 30 15:47:18 CST 2019");

        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:dd").format(d));


    }

}
