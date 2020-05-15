package com.jrx.utils;

/**
 * 错误信息常量 Created by fuqingyuan on 2017/9/4.
 */
public class ErrorConstants
{

    /** 公共 */
    // 系统异常
    public static String ERROR_SYSTEM_EXCEPTION = "SYSTEM EXCEPTION";
    public static final String ERROR_SYSTEM_EXCEPTION_CODE = "9999";
    // 线程异常
    public static final String ERROR_INTERRUPTED_EXCEPTION_CODE = "9998";
    // 任务异常
    public static final String ERROR_EXECUTION_EXCEPTION_CODE = "9997";

    // 时间转换错误
    // String类型的时间转换Date错误
    public static String ERROR_STRING_TO_DATE_FAIL = "String to Date transform exception";
    public static String ERROR_STRING_TO_DATE_FAIL_CODE = "9996";
    // 毫秒值转换时间错误
    public static String ERROR_MS_TO_DATE_FAIL = "millisecond to Date transform exception";
    public static String ERROR_MS_TO_DATE_FAIL_CODE = "9995";
    // 获取系统时间错误
    public static String ERROR_ACQUIRE_SYSTEM_TIME_FAIL = "acquire system time exception";
    public static String ERROR_ACQUIRE_SYSTEM_TIME_FAIL_CODE = "9994";
    // 获取系统日期错误
    public static String ERROR_ACQUIRE_SYSTEM_DATE_FAIL = "acquire system date exception";
    public static String ERROR_ACQUIRE_SYSTEM_DATE_FAIL_CODE = "9993";
    // 返回正确错误信息
    public static String ERROR_THREE_RESULT_CORRECT_ERR_INFO = "three result correct err info";
    public static String ERROR_THREE_RESULT_CORRECT_ERR_INFO_CODE = "9992";
    // 您的请求已超时，请重新在发
    public static String ERROR_TIME_OUT = "Your request is timeout, please again hair";
    public static String ERROR_TIME_OUT_CODE = "9000";

    // Map/Bean互转错误
    // Map 转 Bean错误
    public static String ERROR_MAP_TO_BEAN_FAIL = "Map to Bean transform exception";
    public static String ERROR_MAP_TO_BEAN_FAIL_CODE = "9989";
    // Bean转 Map错误
    public static String ERROR_BEAN_TO_MAP_FAIL = "Bean to Map transform exception";
    public static String ERROR_BEAN_TO_MAP_FAIL_CODE = "9988";

    public static String ERROR_QUERY_IS_NULL = "Query data is empty";
    public static String ERROR_QUERY_IS_NULL_CODE = "9002";

    /** 百融 */
    // 百融登录接口系统异常
    public static String BR_LOGIN_SYSTEM_EXCEPTION = "BaiRong login system exception";
    public static String BR_LOGIN_SYSTEM_EXCEPTION_CODE = "0500";

    // 百融返回数据为空
    public static String BR_DATA_IS_NULL = "BaiRong results data is null";
    public static String BR_DATA_IS_NULL_CODE = "0501";
    // 百融系统异常
    public static String BR_SYSTEM_EXCEPTION = "BaiRong system exception";
    public static String BR_SYSTEM_EXCEPTION_CODE = "0502";
    // 百融未获取登录 接口tokenId
    public static String BR_LOGIN_DID_NOT_GET_TOKEN_ID = "tokenId is null";
    public static String BR_LOGIN_DID_NOT_GET_TOKEN_ID_CODE = "0503";

    /** 芝麻 */
    // 芝麻返回数据为空
    public static String ZM_DATA_IS_NULL = "ZhiMa results data is null";
    public static String ZM_DATA_IS_NULL_CODE = "4000";
    // 芝麻系统异常
    public static String ZM_SYSTEM_EXCEPION = "ZhiMa system exception";
    public static String ZM_SYSTEM_EXCEPION_CODE = "4001";
    // 芝麻反欺诈异常
    public static String ZM_API_EXCEPTION = "ZhiMa api exception";
    public static String ZM_API_EXCEPTION_CODE = "4002";
    // 无法获取授权
    public static String ERROR_ERROR_NOTOPENID = "Zhima Unable to get authorization";
    public static String ERROR_ERROR_NOTOPENID_CODE = "4003";

    /** 人行征信 */
    // 人行征信返回数据为空
    public static String RH_DATA_IS_NULL = "RenHangZhengXin results data is null";
    public static String RH_DATA_IS_NULL_CODE = "4600";

    /** 鹏元 */
    public static String PY_DATA_IS_NULL = "PengYuan results data is null";
    public static String PY_DATA_IS_NULL_CODE = "4500";

    public static String PY_NOT_THIS_QUERY = "Does not support this query types";
    public static String PY_NOT_THIS_QUERY_CODE = "4501";

    // String写成Xml时异常
    public static String PY_STRING_TO_XML_EXCEPTION = "Pengyuan string to xml exception";
    public static String PY_STRING_TO_XML_EXCEPTION_CODE = "4502";

}
