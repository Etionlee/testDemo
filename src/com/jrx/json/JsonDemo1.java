//*****************************************************************************
//
// File Name       :  com.jrx.json.JsonDemo1
// Date Created    :  2019/11/6
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/11/6
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.json;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Etionlee on 2019/11/6.
 */
public class JsonDemo1
{
    public static void main(String[] args)
    {
        JSONObject jsonObject = new JSONObject();
        net.sf.json.JSONObject j2 = new net.sf.json.JSONObject();
        System.out.println(jsonObject.getString("dd"));
        System.out.println(j2.getString("dd"));
    }
}
