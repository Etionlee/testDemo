package com.jrx.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hanchaoyong
 */
public class HttpUtilForEst
{

    static final Logger logger = LoggerFactory.getLogger(HttpUtilForEst.class);

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 180000;
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_ENCODING = "UTF-8";

    static
    {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时时间，单位毫秒。
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        requestConfig = configBuilder.build();
    }





    /**
     * 发送 POST 请求（HTTP），不带输入数据
     *
     * @param apiUrl
     * @return
     */
    public static String doPost(String apiUrl)
    {
        return doPost(apiUrl, new HashMap());
    }


    /**
     * 发送 POST 请求（HTTP），K-V形式
     *
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return 请求返回内容
     */
    public static String doPost(String apiUrl, Map<String, Object> params)
    {
        logger.info("apiUrl : " + apiUrl);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        try
        {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(CONTENT_ENCODING)));
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, CONTENT_ENCODING);
        }
        catch (IOException e)
        {
            logger.error("", e);
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
                    logger.error("", e);
                }
            }
        }
        return httpStr;
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
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, CONTENT_ENCODING);
        }
        catch (IOException e)
        {
            logger.error("", e);
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
                    logger.error("", e);
                }
            }
        }
        return httpStr;
    }


    public static HttpEntity doGetForEntity(String apiUrl)
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpGet httpGet = new HttpGet(apiUrl);

        CloseableHttpResponse response = null;

        try
        {
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return entity;
        }
        catch (IOException e)
        {
            logger.error("", e);
        }
        finally
        {

        }
        return null;
    }


    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式
     *
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return 请求返回内容
     */
    public static String doPostSSL(String apiUrl, Map<String, Object> params)
    {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
                .setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try
        {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(CONTENT_ENCODING)));
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK)
            {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null)
            {
                return null;
            }
            httpStr = EntityUtils.toString(entity, CONTENT_ENCODING);
        }
        catch (Exception e)
        {
            logger.error("", e);
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
                    logger.error("", e);
                }
            }
        }
        return httpStr;
    }


    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式
     *
     * @param apiUrl API接口URL
     * @param json JSON对象
     * @return 请求返回内容
     */
    public static String doPostSSL(String apiUrl, Object json)
    {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory())
                .setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try
        {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), CONTENT_ENCODING);// 解决中文乱码问题
            stringEntity.setContentEncoding(CONTENT_ENCODING);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK)
            {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null)
            {
                return null;
            }
            httpStr = EntityUtils.toString(entity, CONTENT_ENCODING);
        }
        catch (Exception e)
        {
            logger.error("", e);
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
                    logger.error("", e);
                }
            }
        }
        return httpStr;
    }


    /**
     * 创建SSL安全连接
     *
     * @return
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory()
    {
        SSLConnectionSocketFactory sslsf = null;
        try
        {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException
                {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1)
                {
                    return true;
                }


                @Override
                public void verify(String host, SSLSocket ssl) throws IOException
                {
                }


                @Override
                public void verify(String host, X509Certificate cert) throws SSLException
                {
                }


                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException
                {
                }
            });
        }
        catch (GeneralSecurityException e)
        {
            logger.error("", e);
        }
        return sslsf;
    }
}
