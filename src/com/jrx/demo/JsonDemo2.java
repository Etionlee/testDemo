//*****************************************************************************
//
// File Name       :  com.jrx.demo.JsonDemo2
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.jrx.utils.Utils;

import java.util.Map;

/**
 * Created by Etionlee on 2019/1/9.
 */
public class JsonDemo2
{
    public static void main(String[] args)
    {

        String jsonStr = "{\"msg\":\"成功\",\"code\":1000,\"data\":{\"msg\":\"成功\",\"realName\":\"张三\",\"code\":\"200\",\"data\":{\"ISPNUM\":{\"province\":\"广西\",\"city\":\"南宁\",\"isp\":\"电信\"},\"RSL\":[{\"RS\":{\"code\":\"0\",\"desc\":\"验证一致\"},\"IFT\":\"A2\"}],\"ECL\":[]},\"phone\":\"13300000001\"},\"responseTimestamp\":1547000527957}";
        // String jsonStr =
        // "{\"msg\":\"成功\",\"code\":1000,\"data\":{\"msg\":\"姓名格式错误\",\"realName\":\"张三1\",\"code\":\"100000802\",\"phone\":\"13300000002\"},\"responseTimestamp\":1547015503971}";
        //String jsonStr = "{\"msg\":\"成功\",\"code\":1000,\"data\": {\"msg\":\"成功\",\"realName\":\"张三\",\"RS_code\":\"0\",\"code\":\"200\",\"province\":\"广西\",\"phone\":\"13300000001\",\"city\":\"南宁\",\"RS_desc\":\"验证一致\",\"IFT\":\"A2\",\"isp\":\"电信\"},\"responseTimestamp\":1547000527957}";

        JSONObject json = JSON.parseObject(jsonStr);
        JSONObject data = json.getJSONObject("data");
        Map<String, Object> source = Maps.newHashMap();
        data.forEach((k, v) -> {
            if (v instanceof JSONArray)
            {}
            if (v instanceof JSONObject)
            {}
            else
            {
                source.put(Utils.underlineToCamel(k), v);
            }
        });
        JSONObject geotmtData = data.getJSONObject("data");
        if (geotmtData != null)
        {
            JSONObject ispnum = geotmtData.getJSONObject("ISPNUM");
            source.putAll(Utils.json2Map(ispnum));
            JSONArray rsl = geotmtData.getJSONArray("RSL");
            for (int i = 0; i < (rsl == null ? 0 : rsl.size()); i++)
            {
                JSONObject jsonObject = rsl.getJSONObject(i);
                source.putAll(Utils.json2Map(jsonObject));
            }
            JSONArray etl = geotmtData.getJSONArray("ETL");
            for (int i = 0; i < (etl == null ? 0 : etl.size()); i++)
            {
                JSONObject jsonObject = etl.getJSONObject(i);
                source.putAll(Utils.json2Map(jsonObject));
            }

        }

        System.out.println(JSON.toJSON(source));
    }
}
