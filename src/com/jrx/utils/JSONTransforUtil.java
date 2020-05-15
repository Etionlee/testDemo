package com.jrx.utils;


import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class JSONTransforUtil
{
    static final Logger logger = LoggerFactory.getLogger(JSONTransforUtil.class);


    public static <T> T fromJson(String jsonString, Class<T> type)
    {
        jsonString = removeStr(jsonString);
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        return (T) JSONObject.toBean(jsonObject, type);
    }


    public static <T> T fromJson(String jsonString, Class<T> type, Map<String, Class> classMap)
    {
        jsonString = removeStr(jsonString);
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        return (T) JSONObject.toBean(jsonObject, type, classMap);
    }





    public static Object getProperty(Object obj, String propertyName)
    {
        Class clazz = obj.getClass();// 获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);// 获取 clazz 类型中的 propertyName 的属性描述器
        Method getMethod = pd.getReadMethod();// 从属性描述器中获取 get 方法
        // System.out.println(getMethod.getName());
        Object value = null;
        try
        {
            // value = getMethod.invoke(clazz, new Object[]{});//调用方法获取方法的返回值
            value = getMethod.invoke(obj, new Object[] {});// 调用方法获取方法的返回值
        }
        catch (Exception e)
        {
            logger.error("异常信息：", e);
        }
        return value;// 返回值
    }


    public static PropertyDescriptor getPropertyDescriptor(Class clazz, String propertyName)
    {

        StringBuffer sb = new StringBuffer(); // 构建一个可变字符串用来构建方法名称
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor pd = null;
        try
        {
            Field f = clazz.getDeclaredField(propertyName); // 根据字段名来获取字段
            if (f != null)
            {
                // 构建方法的后缀
                String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                sb.append("set" + methodEnd); // 构建set方法
                setMethod = clazz.getDeclaredMethod(sb.toString(), new Class[] { f.getType() });
                sb.delete(0, sb.length()); // 清空整个可变字符串
                sb.append("get" + methodEnd); // 构建get方法
                // 构建get 方法
                getMethod = clazz.getDeclaredMethod(sb.toString(), new Class[] {});
                // 构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                pd = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        }
        catch (Exception ex)
        {
            logger.error("异常信息：", ex);
        }
        return pd;
    }


    private static String removeStr(String json)
    {
        if (json == null || "".equals(json))
        {
            return null;
        }
        if (json.startsWith("\""))
        {
            json = json.replaceFirst("\"", "");
        }
        if (json.endsWith("\""))
        {
            json = json.substring(0, json.length() - 1);
        }
        return json;
    }

}
