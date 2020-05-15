package com.jrx.comperss;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EstDecisionKeepAliveFalse
{
    static RequestConfig requestConfig;
    static final int MAX_TIMEOUT = 180000;
    static final String APPLICATION_JSON = "application/json";
    static final String CONTENT_ENCODING = "UTF-8";

    static
    {

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时时间，单位毫秒。
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        requestConfig = configBuilder.build();
    }


    public EstDecisionKeepAliveFalse()
    {
    }


    public void justDoIt()
    {
        try
        {
            EstDecisionKeepAliveFalse aliComperss = new EstDecisionKeepAliveFalse();

            Map<String, Object> paramMap = new HashMap<String, Object>();
            JSONObject propertiesJson = new JSONObject();
            propertiesJson.put("certNo", "320122199207012420");// 证件号码
            propertiesJson.put("mobile", "13188822221");// 手机号
            propertiesJson.put("name", "刘敏");// 客户姓名
            propertiesJson.put("riskCheckApplyNo", "");// 风险核查申请号
            propertiesJson.put("company_name", "拳头工作室");// 所在公司
            propertiesJson.put("liveAddress", "江苏省南京市");// 地址

            paramMap.put("$eventTime", System.currentTimeMillis());// 事件时间
            paramMap.put("$event", "还呗风险核查事件");// 事件名称 准入/授信
            paramMap.put("$eventNo", "bf2dfa0d6abd40588475d431077f7ff2");// 事件编号 UUID
            paramMap.put("$actKey", "huanbeifengxianhecha");// 事件活动应用key
            paramMap.put("$properties", propertiesJson);// 值为传入业务字段的json字符串
            paramMap.put("$channel", "还呗风险核查");

            JSONObject jsonObject = JSONObject.fromObject(paramMap);
            System.out.println("调用est授信请求：" + jsonObject.toString());
            String result = aliComperss.doPost("http://66.56.96.62:5850/decision",
                    com.alibaba.fastjson.JSONObject.toJSONString(jsonObject));
            JSONObject resultJson = JSONObject.fromObject(result);
            System.out.println("调用est授信结果" + resultJson.toString());
        }
        catch (Exception var3)
        {
            var3.printStackTrace();
        }

    }


    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param apiUrl API接口URL
     * @param json json对象
     * @return 请求返回内容
     */
    public static String doPost(String apiUrl, String json)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);

        CloseableHttpResponse response = null;

        try
        {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json, CONTENT_ENCODING);// 解决中文乱码问题
            stringEntity.setContentEncoding(CONTENT_ENCODING);
            stringEntity.setContentType(APPLICATION_JSON);
            httpPost.setHeader("connection", "close");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, CONTENT_ENCODING);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume(response.getEntity());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

}
