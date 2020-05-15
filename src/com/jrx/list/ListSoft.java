package com.jrx.list;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author liyx
 * @CreateDate 2020/4/28
 * @Version
 */
public class ListSoft
{
    public static void main(String[] args)
    {
        List<JSONObject> list = new ArrayList<>();
        JSONObject j0 = new JSONObject();
        j0.put("id", 1);
        j0.put("a", 1231);
        j0.put("b", 23);
        j0.put("msg", "通过");
        list.add(j0);
        JSONObject j2 = new JSONObject();
        j2.put("id", 2);
        j2.put("a", 2000);
        j2.put("b", 50);
        j2.put("msg", "通过");
        list.add(j2);
        JSONObject j3 = new JSONObject();
        j3.put("id", 3);
        j3.put("a", 2000);
        j3.put("b", 1);
        j3.put("msg", "通过");
        list.add(j3);
        JSONObject j4 = new JSONObject();
        j4.put("id", 4);
        j4.put("a", 2000);
        j4.put("b", 3);
        j4.put("msg", "通过");
        list.add(j4);
        JSONObject j5 = new JSONObject();
        j5.put("id", 5);
        j5.put("a", 200);
        j5.put("b", 123);
        j5.put("msg", "通过");
        list.add(j5);
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size() - i - 1; j++)
            {
                if ("通过".equals(list.get(j).getString("msg")))
                {
                    if ("通过".equals(list.get(j + 1).getString("msg")))
                    {
                        if (list.get(j).getInteger("a") < list.get(j + 1).getInteger("a"))
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

        System.out.println(list.toString());
    }

}
