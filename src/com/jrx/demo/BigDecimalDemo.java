//*****************************************************************************
//
// File Name       :  com.jrx.demo.BigDecimalDemo
// Date Created    :  2019/6/24
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/6/24
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

import java.text.NumberFormat;

/**
 * Created by Etionlee on 2019/6/24.
 */
public class BigDecimalDemo
{
    public static void main(String[] args)
    {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(5);

        String failPer = numberFormat.format((float) 1 / (float) 200 * 100);
        float f = Float.valueOf(failPer);

        System.out.println(failPer);
        System.out.println(f);
    }
}
