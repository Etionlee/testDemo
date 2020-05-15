//*****************************************************************************
//
// File Name       :  com.jrx.json.JsonDemo2
// Date Created    :  2019/11/11
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/11/11
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.json;

import net.sf.json.JSONObject;

/**
 * Created by Etionlee on 2019/11/11.
 */
public class JsonDemo2
{
    public static void main(String[] args)
    {
        String jsonStr = "{\"hitRules3\":\"A3\",\"$eventNo\":\"a06fafe532b248a3bed31056cb707c71\",\"hbCheckRslt\":\"拒绝\",\"result\":\"加载成功\",\"hitRules14\":\"D1\",\"hitRules12\":\"C3\",\"hitRules11\":\"C2\",\"hitRules10\":\"C1\",\"hitRules8\":\"B2\",\"#score3\":\"-16.383205716188314\",\"#score4\":\"60\",\"hitRules19\":\"E3\",\"#score1\":\"18000.0\",\"hitRules4\":\"A4\",\"hitRules18\":\"E2\",\"#score2\":\"-0.17669921623114926\",\"hitRules5\":\"A5\",\"hitRules6\":\"A6\",\"hbCheckRjcode\":\"H203\",\"hitRules15\":\"D2\"}";
        net.sf.json.JSONObject estResult = JSONObject.fromObject(jsonStr);

        StringBuffer hitRulesSb = new StringBuffer();
        for (int i = 1; i <= 19; i++)
        {
            if (estResult.containsKey("hitRules" + i))
            {
                String value = estResult.getString("hitRules" + i);
                if (value != null)
                {
                    hitRulesSb.append(value).append(",");
                }
            }
        }
        System.out.println(hitRulesSb.length() > 0 ? hitRulesSb.substring(0, hitRulesSb.length() - 1) : "");

    }
}
