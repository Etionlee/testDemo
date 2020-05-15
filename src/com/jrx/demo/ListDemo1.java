//*****************************************************************************
//
// File Name       :  com.jrx.demo.ListDemo1
// Date Created    :  2019/8/16
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/8/16
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Etionlee on 2019/8/16.
 */
public class ListDemo1
{
    public static void main(String[] args)
    {
        Map<String, Object> temp = new HashMap<>();
        temp.put("dict_value", "aaa");
        List<Map<String, Object>> kedActKeyList = new ArrayList<>();
        kedActKeyList.add(temp);


        String arr[] = new String[100];
        for(int i=0;i<kedActKeyList.size();i++){
            arr[i]= String.valueOf(kedActKeyList.get(i).get("dict_value"));
        }
        System.out.println(arr.toString());
    }
}
