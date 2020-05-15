package com.jrx.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类 Created by fuqingyuan on 2017/8/24.
 */
public class Utils
{

    private static Logger logger = LoggerFactory.getLogger(Utils.class);


    /**
     * 转成string
     *
     * @param obj
     * @return
     */
    public static String getString(Object obj)
    {
        if (obj == null)
        {
            return "";
        }
        return obj.toString();
    }


    public static String delspecialsign(String str)
    {
        if (str.indexOf("\"") != -1)
        {
            str = str.replaceAll("\"", "");
        }
        return str;
    }


    public static boolean isEmpty(Object obj)
    {
        if (obj != null && obj.toString().length() > 0 && !"".equals(obj))
        {
            return false;
        }
        return true;
    }


    public static boolean isEmpty(String str)
    {

        if (str != null && str.length() > 0 && !"".equals(str))
        {
            return false;
        }
        return true;
    }


    public static int isJSONType(Object obj)
    {
        if (isEmpty(obj))
            return -1;

        String s = obj.toString();

        if (s.startsWith("[") && s.endsWith("]"))
        {
            return 1;
        }

        if (s.startsWith("{") && s.startsWith("}"))
        {
            return 0;
        }
        return -1;
    }


    public static boolean createFile(String destFileName)
    {
        File file = new File(destFileName);
        if (file.exists())
        {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
            return false;
        }
        if (destFileName.endsWith(File.separator))
        {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return false;
        }
        return createFile(file);
    }


    public static boolean createFile(File file)
    {

        // 判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists())
        {
            // 如果目标文件所在的目录不存在，则创建父目录
            if (!file.getParentFile().mkdirs())
            {
                return false;
            }
        }
        String destFileName = "";
        // 创建目标文件
        try
        {
            destFileName = file.getCanonicalPath();
            if (file.createNewFile())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (IOException e)
        {
            logger.error("异常信息：", e);
            return false;
        }
    }


    public static boolean createDir(String destDirName)
    {
        File dir = new File(destDirName);
        if (dir.exists())
        {
            return false;
        }
        if (!destDirName.endsWith(File.separator))
        {
            destDirName = destDirName + File.separator;
        }
        // 创建目录
        if (dir.mkdirs())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static String createTempFile(String prefix, String suffix, String dirName)
    {
        File tempFile = null;
        if (dirName == null)
        {
            try
            {
                // 在默认文件夹下创建临时文件
                tempFile = File.createTempFile(prefix, suffix);
                // 返回临时文件的路径
                return tempFile.getCanonicalPath();
            }
            catch (IOException e)
            {
                logger.error("异常信息：", e);
                return null;
            }
        }
        else
        {
            File dir = new File(dirName);
            // 如果临时文件所在目录不存在，首先创建
            if (!dir.exists())
            {
                if (!createDir(dirName))
                {
                    return null;
                }
            }
            try
            {
                // 在指定目录下创建临时文件
                tempFile = File.createTempFile(prefix, suffix, dir);
                return tempFile.getCanonicalPath();
            }
            catch (IOException e)
            {
                logger.error("异常信息：", e);
                return null;
            }
        }
    }


    public static Map<String, Object> json2Map(JSONObject dataJson)
    {
        Map<String, Object> source = Maps.newHashMap();
        dataJson.forEach((k, v) -> {
            if (v instanceof JSONObject)
            {
                JsonFormatUtils.singleFormat(dataJson, k, null, source);
            }
            else if (v instanceof JSONArray)
            {
                JsonFormatUtils.listFormat(dataJson, k, null, source);
            }
            else
            {
                source.put(Utils.underlineToCamel(k), v);
            }

        });
        return source;
    }


    public static Map<String, Object> fastJson2Map(JSONObject dataJson)
    {
        return fastJson2Map(dataJson.toJSONString());
    }


    public static Map<String, Object> fastJson2Map(String jsonString)
    {
        return JSON.parseObject(jsonString, Map.class);
    }


    public static JSONObject map2FastJson(Map<String, Object> params)
    {
        if (params == null || params.isEmpty())
        {
            return new JSONObject();
        }
        return JSON.parseObject(JSON.toJSONString(params));
    }


    // Introspector, map 转 javabean
    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass)
    {
        if (map == null)
            return null;

        try
        {
            Object obj = beanClass.newInstance();

            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors)
            {
                Method setter = property.getWriteMethod();
                Object value = map.get(property.getName());
                if (setter != null)
                {
                    setter.invoke(obj, value);
                }
            }
            return (T) obj;
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            return null;
        }
    }


    // Introspector, javabean 转 map
    public static Map<String, Object> objectToMap(Object obj)
    {
        return objectToMap(obj, 0);
    }


    /**
     * 对象转map
     *
     * @param obj
     * @param mode, map key模式, 0 默认, 1 驼峰, 2 下划线
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj, int mode)
    {
        if (obj == null)
            return null;

        if (mode != 1 && mode != 2)
            mode = 0;
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();

            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors)
            {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0)
                {
                    continue;
                }
                Method getter = property.getReadMethod();

                Object value = null;
                if (getter != null)
                {
                    value = getter.invoke(obj);
                    if (value instanceof Date)
                    {
                        value = DateUtils.getDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                    }
                }
                map.put((mode == 1 ? underlineToCamel2(key) : (mode == 2 ? camelToUnderline(key) : key)), value);
            }
            return map;
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            return null;
        }
    }


    public static final char UNDERLINE = '_';


    public static String camelToUnderline(String param)
    {
        if (param == null || "".equals(param.trim()))
        {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            char c = param.charAt(i);
            if (Character.isUpperCase(c))
            {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static String underlineToCamel(String param)
    {
        if (param == null || "".equals(param.trim()))
        {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            char c = param.charAt(i);
            if (c == UNDERLINE)
            {
                if (++i < len)
                {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static String underlineToCamel2(String param)
    {
        if (param == null || "".equals(param.trim()))
        {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find())
        {
            int position = mc.end() - (i++);
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }


    public static BigDecimal getBigDecimal(Object value)
    {
        BigDecimal b = BigDecimal.ZERO;
        if (value != null)
        {
            if (value instanceof BigDecimal)
            {
                b = (BigDecimal) value;
            }
            else if (value instanceof String)
            {
                if ("".equals(value))
                    return b;
                b = new BigDecimal((String) value);
            }
            else if (value instanceof BigInteger)
            {
                b = new BigDecimal((BigInteger) value);
            }
            else if (value instanceof Number)
            {
                b = new BigDecimal(((Number) value).doubleValue());
            }
            else
            {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
                        + " into a BigDecimal.");
            }
        }
        return b;
    }


    public static JSONObject getJSONObject(File file)
    {
        return getJSONObject(file, null);
    }


    public static JSONObject getJSONObject(File file, String charset)
    {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try
        {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream,
                    isEmpty(charset) ? "UTF-8" : charset);
            reader = new BufferedReader(inputStreamReader);
            String tempString = "";
            while ((tempString = reader.readLine()) != null)
            {
                builder.append(tempString);
            }
            reader.close();
            reader = null;
            fileInputStream.close();
            fileInputStream = null;
            inputStreamReader.close();
            inputStreamReader = null;
            return JSON.parseObject(builder.toString());
        }
        catch (IOException e)
        {
            logger.error("异常信息：", e);
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException el)
                {
                }
            }
            if (fileInputStream != null)
            {
                try
                {
                    fileInputStream.close();
                }
                catch (IOException el)
                {
                }
            }
            if (inputStreamReader != null)
            {
                try
                {
                    inputStreamReader.close();
                }
                catch (IOException el)
                {
                }
            }
        }
        return null;
    }


    /**
     * 生成交易流水号(日期+流水)17位时间值+13位自增数
     *
     * @return 交易流水号
     */
    public static String getTransactionId()
    {
        String date = DateUtils.getCurrentDataTimePure();
        String random = String.valueOf((long) (Math.random() * 9 * Math.pow(10, 13 - 1)) + (long) Math.pow(10, 13 - 1));
        return date + random;
    }


    /**
     * 生成交易流水号（20位：17位时间值+3位随机数）
     *
     * @return
     */
    public static String getTransactionId20()
    {
        // yyyyMMddHHmmssSSS 17位时间值
        String date = DateUtils.getSysCurrentDataTime();
        // [100-999)的随机数
        String random = String.valueOf((int) (Math.random() * 900) + 100);

        return date + random;
    }


    /**
     * 判断是否包含中文
     *
     * @param s
     * @return true:包含 false:不包含
     */
    public static boolean isContainChinese(String s)
    {
        boolean containChinese = false;

        if (s == null || isEmpty(s))
        {
            return false;
        }

        String reg = "^[\u4e00-\u9fa5]*$";
        char[] charResult = s.toCharArray();
        for (int i = 0; i < charResult.length; i++)
        {
            String tempString = String.valueOf(charResult[i]);
            if (tempString.matches(reg))
            {
                containChinese = true;
                break;
            }
        }

        return containChinese;
    }


    public static void main(String[] args)
    {
        System.out.println(getTransactionId());
    }
}
