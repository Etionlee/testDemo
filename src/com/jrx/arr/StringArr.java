//*****************************************************************************
//
// File Name       :  com.jrx.arr.StringArr
// Date Created    :  2020/2/26
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/2/26
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.arr;

import java.util.Arrays;

/**
 * Created by Etionlee on 2020/2/26.
 */
public class StringArr
{
    public static void main(String[] args)
    {
        String thirdNameArr[] = new String[1];
        thirdNameArr[0] = "interface_zjrcbankcreditreport";

        System.out.println(Arrays.asList(thirdNameArr).contains("interface_esbrisk01"));
    }
}
