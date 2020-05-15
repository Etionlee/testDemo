//*****************************************************************************
//
// File Name       :  com.jrx.http.DecisionDemo
// Date Created    :  2020/2/24
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/2/24
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.http;

import com.jrx.utils.HttpUtilForEst;
import net.sf.json.JSONObject;

/**
 * Created by Etionlee on 2020/2/24.
 */
public class DecisionDemo
{
    public static void main(String[] args)
    {
            JSONObject propertiesJson = new JSONObject();
            propertiesJson.put("certNo", "320882199005045513");// 证件号码
            propertiesJson.put("mobile", "13814061863");// 手机号
            propertiesJson.put("name", "李镒星03");// 客户姓名
            propertiesJson.put("riskCheckApplyNo", "");// 风险核查申请号
            propertiesJson.put("company_name","拳头工作室");// 所在公司
            propertiesJson.put("liveAddress","江苏省南京市建邺区江东中路1号");//地址

            String result = HttpUtilForEst.doPost("http://66.56.96.58:8080/operate/decision", com.alibaba.fastjson.JSONObject.toJSONString(propertiesJson));
            JSONObject resultJson = JSONObject.fromObject(result);
            System.out.println(resultJson.toString());

    }


   /* public void test(){
        String url = "http://66.56.96.62:8080/decision";
        JSONObject resultJson = null;
        try
        {
            JSONObject propertiesJson = new JSONObject();
            propertiesJson.put("ertinum", 12345);
            propertiesJson.put("handset", "13813818888");

            propertiesJson.info("调用Operate est准入请求：" + propertiesJson.toString());
            String result = HttpUtilForEst.doPost(url,com.alibaba.fastjson.JSONObject.toJSONString(propertiesJson));
            log.info("调用Operate est准入响应：" + result);
            resultJson = JSONObject.fromObject(result);
        }
        catch (Exception e)
        {
            propertiesJson.info("调用Operate EST异常");
            propertiesJson.error(e.getMessage());
        }
    }*/
}
