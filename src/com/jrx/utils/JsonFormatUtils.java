package com.jrx.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/31.
 */
public class JsonFormatUtils
{
    public static void singleFormat(JSONObject json, String key, String prefix, Map<String, Object> source)
    {
        if (json.containsKey(key))
        {
            if (json.get(key) instanceof JSONArray)
            {
                JSONArray array = json.getJSONArray(key);
                if (array.size() > 0)
                {
                    JSONObject entity = array.getJSONObject(0);
                    entity.forEach((k, v) -> {
                        if (v != null) source.put((prefix == null ? Utils.underlineToCamel(key) : prefix) + "_"
                                + Utils.underlineToCamel(k), v.toString());
                    });
                }
            }
            if (json.get(key) instanceof JSONObject)
            {
                JSONObject jsonObject = json.getJSONObject(key);
                jsonObject.forEach((k, v) -> {
                    if (v != null)
                    {
                        if (v instanceof JSONArray)
                        {
                            listFormat(jsonObject, k, Utils.underlineToCamel(key) + "_" + Utils.underlineToCamel(k),
                                    source);
                        }
                        else
                        {
                            source.put((prefix == null ? Utils.underlineToCamel(key) : prefix) + "_"
                                    + Utils.underlineToCamel(k), v.toString());
                        }
                    }
                });
            }
        }
    }


    public static void listFormat(JSONObject json, String key, String prefix, Map<String, Object> source)
    {
        if (json.containsKey(key))
        {
            JSONArray array = json.getJSONArray(key);
            if (array == null || array.size() == 0)
            {
                String mapKey = (prefix == null ? Utils.underlineToCamel(key) : prefix);
                source.put(mapKey, array);
                return;
            }
            array.forEach((arrayValue) -> {
                if (arrayValue instanceof JSONObject)
                {
                    ((JSONObject) arrayValue).forEach((k, v) -> {
                        String mapKey = (prefix == null ? Utils.underlineToCamel(key) : prefix) + "_"
                                + Utils.underlineToCamel(k);
                        JSONArray mapValue;
                        if (source.containsKey(mapKey))
                        {
                            mapValue = (JSONArray) source.get(mapKey);
                        }
                        else
                        {
                            mapValue = new JSONArray();
                        }
                        mapValue.add(v);
                        source.put(mapKey, mapValue);
                    });
                }
                else
                {
                    String mapKey = (prefix == null ? Utils.underlineToCamel(key) : prefix);
                    JSONArray mapValue;
                    if (source.containsKey(mapKey))
                    {
                        mapValue = (JSONArray) source.get(mapKey);
                    }
                    else
                    {
                        mapValue = new JSONArray();
                    }
                    mapValue.add(arrayValue);
                    source.put(mapKey, mapValue);
                }
            });
        }
    }
}
