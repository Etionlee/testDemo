//*****************************************************************************
//
// File Name       :  com.jrx.demo.IntegerDemo
// Date Created    :  2019/7/17
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/7/17
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

/**
 * Created by Etionlee on 2019/7/17.
 */
public class IntegerDemo
{
    public static void main(String[] args)
    {
        String a = "01";
        Integer b = 1;
        String sb= "";
        if (b < 10)
        {
            sb = "0" + b;
        }


        System.out.println("0"+(Integer.parseInt(a)+1));
        System.out.println(sb);
    }
}
