//*****************************************************************************
//
// File Name       :  com.jrx.demo.StringDemo
// Date Created    :  2019/7/29
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/7/29
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Etionlee on 2019/7/29.
 */
public class StringDemo
{
    public static void main(String[] args)
    {
        String a = "http://66.56.96.6:9750/api/";
        String b = "huanbei/";
        String c = "operate";
        a += b + c;
        System.out.println(a);
        Map map = new HashMap();
        System.out.println(map.get("isHaveHouse"));
        System.out.println(String.valueOf(map.get("isHaveHouse")));
        System.out.println(String.valueOf(null));
    }
}
