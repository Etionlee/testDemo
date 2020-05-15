package com.jrx.list;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author liyx
 * @CreateDate 2020/4/30
 * @Version
 */
public class ListSoft2
{
    public static void main(String[] args)
    {
        net.sf.json.JSONObject resultObject = new net.sf.json.JSONObject();
        // 冒泡排序，获取通过的金额最高的产品，金额相同优先级 钱包e贷＞ 快e贷＞税e贷
        List<JSONObject> list = new ArrayList<>();
        JSONObject qbObj = new JSONObject();

        String qbedLimit = "100";// 钱包E贷额度
        String qbedRate = "0.201"; // 钱包E贷利率

        String qbedProId = "钱包E贷";// 钱包E带产品ID
        qbObj.put("result", "通过");
        qbObj.put("limit", qbedLimit);
        qbObj.put("rate", qbedRate);
        qbObj.put("proId", qbedProId);
        list.add(qbObj);

        JSONObject kedObj = new JSONObject();
        String kedLimit = "100"; // 快E贷额度
        String kedRate = "0.111202"; // 快E贷利率
        String kedProId = "快E贷";// 快E贷利率产品ID
        kedObj.put("result", "通过");
        kedObj.put("limit", kedLimit);
        kedObj.put("rate", kedRate);
        kedObj.put("proId", kedProId);
        list.add(kedObj);

        JSONObject sedObj = new JSONObject();
        String sedLimit = "100"; // 税E贷额度
        String sedRate = "0.5556"; // 税E带利率
        String sedProId = "E贷";// 税E带产品ID
        sedObj.put("result", "通过");
        sedObj.put("limit", sedLimit);
        sedObj.put("rate", sedRate);
        sedObj.put("proId", sedProId);
        list.add(sedObj);

        System.out.println("金额排序前：" + list.toString());
        softLimitDesc(list);
        System.out.println("金额排序后：" + list.toString());

        // 三个额度相同
        if (new BigDecimal(list.get(0).getString("limit"))
                .compareTo(new BigDecimal(list.get(1).getString("limit"))) == 0
                && new BigDecimal(list.get(1).getString("limit"))
                        .compareTo(new BigDecimal(list.get(2).getString("limit"))) == 0)
        {
            List<JSONObject> rateList = new ArrayList<>();
            rateList.addAll(list);
            System.out.println("利率排序前：" + rateList.toString());
            softRateAsc(rateList);
            System.out.println("利率排序后：" + rateList.toString());
            resultObject.put("zjedLoanlimit", rateList.get(0).getString("limit"));
            resultObject.put("zjedLendingRate", rateList.get(0).getString("rate"));
            resultObject.put("productId", rateList.get(0).getString("proId"));
        }
        // 前两个额度相同 取利率最低
        else if (new BigDecimal(list.get(0).getString("limit"))
                .compareTo(new BigDecimal(list.get(1).getString("limit"))) == 0)
        {
            List<JSONObject> rateList = new ArrayList<>();
            rateList.add(list.get(0));
            rateList.add(list.get(1));
            System.out.println("利率排序前：" + rateList.toString());
            softRateAsc(rateList);
            System.out.println("利率排序后：" + rateList.toString());
            resultObject.put("zjedLoanlimit", rateList.get(0).getString("limit"));
            resultObject.put("zjedLendingRate", rateList.get(0).getString("rate"));
            resultObject.put("productId", rateList.get(0).getString("proId"));
        }
        // 取额度最高
        else
        {
            resultObject.put("zjedLoanlimit", list.get(0).getString("limit"));
            resultObject.put("zjedLendingRate", list.get(0).getString("rate"));
            resultObject.put("productId", list.get(0).getString("proId"));
        }

        System.out.println("-------" + resultObject.toString());

    }


    /**
     * 根据金额倒序，第一个最大
     *
     * @param list
     */
    private static void softLimitDesc(List<JSONObject> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size() - i - 1; j++)
            {
                if ("通过".equals(list.get(j).getString("result")))
                {
                    if ("通过".equals(list.get(j + 1).getString("result")))
                    {
                        if (new BigDecimal(list.get(j).getString("limit"))
                                .compareTo(new BigDecimal(list.get(j + 1).getString("limit"))) < 0)
                        {
                            JSONObject r = list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j + 1, r);
                        }
                    }
                }
                else
                {
                    JSONObject r = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, r);
                }
            }
        }
    }


    /**
     * 根据利率升序，第一个最小
     *
     * @param list
     */
    private static void softRateAsc(List<JSONObject> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size() - i - 1; j++)
            {
                if ("通过".equals(list.get(j).getString("result")))
                {
                    if ("通过".equals(list.get(j + 1).getString("result")))
                    {
                        if (new BigDecimal(list.get(j).getString("rate"))
                                .compareTo(new BigDecimal(list.get(j + 1).getString("rate"))) > 0)
                        {
                            JSONObject r = list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j + 1, r);
                        }
                    }
                }
                else
                {
                    JSONObject r = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, r);
                }
            }
        }
    }

}
