//*****************************************************************************
//
// File Name       :  com.jrx.demo.JsonDemo1
// Date Created    :  2019/1/9
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/1/9
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.jrx.utils.Utils;

import java.util.Map;

/**
 * Created by Etionlee on 2019/1/9.
 */
public class JsonDemo1
{
    public static void main(String[] args)
    {

        String jsonStr = "{\"msg\":\"成功\",\"code\":1000,\"data\": {\"msg\":\"成功\",\"realName\":\"张三\",\"RS_code\":\"0\",\"code\":\"200\",\"province\":\"广西\",\"phone\":\"13300000001\",\"city\":\"南宁\",\"RS_desc\":\"验证一致\",\"IFT\":\"A2\",\"isp\":\"电信\"},\"responseTimestamp\":1547000527957}";
        JSONObject json = JSON.parseObject(jsonStr);
        JSONObject dataJson = json.getJSONObject("data");
        Map<String, Object> source = Maps.newHashMap();
        source = Utils.json2Map(dataJson);
        System.out.println(source);
    }
}
