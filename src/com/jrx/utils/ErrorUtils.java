package com.jrx.utils;


import com.alibaba.fastjson.JSONObject;


/**
 * 返回错误信息工具类
 */
public class ErrorUtils
{
    /**
     * 错误信息数据整理
     * 
     * @param errCode 错误码
     * @param errInfo 错误信息
     * @return 错误集合
     */
    public static String errorText(String errCode, String errInfo)
    {
        JSONObject json = new JSONObject();
        json.put(Constants.ERR_CODE, errCode);
        json.put(Constants.ERR_INFO, errInfo);
        return json.toString();
    }
}