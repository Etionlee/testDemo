package com.jrx.sign;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA非对称加密算法工具
 * 
 * @author wen.wan
 *
 */
public class RSAUtil
{

    /**
     * 加密算法
     */
    public static final String ALGORITHM_RSA = "RSA";

    /**
     * 算法/模式/填充
     */
    public static final String CIPHER_TRANSFORMATION_RSA = "RSA/ECB/PKCS1Padding";

    /**
     * 密钥长度
     */
    private static final int KEY_SIZE = 1024;

    /**
     * 分块加密长度
     */
    private static final int MAX_ENCRYPT_BLOCK = KEY_SIZE / 8 - 11;

    /**
     * 单次解密最大密文长度，这里仅仅指1024bit 长度密钥
     *
     */
    public static final int MAX_DECRYPT_BLOCK = 128;

    /** UTF-8字符集 **/
    public static final String CHARSET_UTF8 = "UTF-8";

    private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F' };


    // 加密文件
    // 解密文件

    /**
     * 生成RSA密钥
     * 
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, String> genKeyPair() throws NoSuchAlgorithmException
    {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyPairGen.initialize(KEY_SIZE);
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); // 得到公钥

        // BASE64加密后的密钥
        String publicKeyBase64Str = new String(Base64.encodeBase64(publicKey.getEncoded()));
        String privateKeyBase64Str = new String(Base64.encodeBase64(privateKey.getEncoded()));

        // 转为16进制的密钥
        // String publicKeyHexStr = bytesToHexStr(publicKey.getEncoded());
        // String privateKeyHexStr = bytesToHexStr(privateKey.getEncoded());

        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("publicKeyBase64Str", publicKeyBase64Str);
        keyMap.put("privateKeyBase64Str", privateKeyBase64Str);
        // keyMap.put("publicKeyHexStr", publicKeyHexStr);
        // keyMap.put("privateKeyHexStr", privateKeyHexStr);
        return keyMap;
    }


    /**
     * RSA 公钥加密
     * 
     * @param content 明文（字节数组）
     * @param publicKey 公钥（字节数组）
     * @return 密文（字节数组）
     * @throws Exception
     */
    private static byte[] encrypt(byte[] content, byte[] publicKey) throws Exception
    {
        ByteArrayOutputStream out = null;
        try
        {
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_RSA)
                    .generatePublic(new X509EncodedKeySpec(publicKey));
            Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] data = content;
            int inputLen = data.length;
            out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0)
            {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK)
                {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                }
                else
                {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return encryptedData;
        }
        catch (Exception e)
        {
            throw new Exception("error occured in rsa encrypt.", e);
        }
        finally
        {
            IOUtil.closeQuietly(out);
        }
    }


    /**
     * RSA 公钥加密
     * 
     * @param content 明文（字节数组）
     * @param publicKeyBase64Str 公钥（BASE64加密的公钥字符串）
     * @param charset 字符集（默认UTF-8）
     * @return 密文（字节数组）
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, String publicKeyBase64Str, String charset) throws Exception
    {
        if (charset == null || "".equals(charset))
        {
            charset = CHARSET_UTF8;
        }
        byte[] keyBytes = Base64.decodeBase64(publicKeyBase64Str.getBytes(charset));
        byte[] encodeBase64Data = Base64.encodeBase64(encrypt(content, keyBytes));
        return encodeBase64Data;
    }


    /**
     * RSA 公钥加密
     * 
     * @param content 明文
     * @param publicKeyBase64Str 公钥（BASE64加密的公钥字符串）
     * @param charset 字符集（默认UTF-8）
     * @return 密文
     * @throws Exception
     */
    public static String encrypt(String content, String publicKeyBase64Str, String charset) throws Exception
    {
        if (charset == null || "".equals(charset))
        {
            charset = CHARSET_UTF8;
        }
        byte[] encodeBase64Data = encrypt(content.getBytes(charset), publicKeyBase64Str, charset);
        return new String(encodeBase64Data, charset);
    }


    /**
     * RSA 私钥解密
     * 
     * @param content 密文（字节数组）
     * @param privateKey 私钥（字节数组）
     * @return 明文（字节数组）
     * @throws Exception
     */
    private static byte[] decrypt(byte[] content, byte[] privateKey) throws Exception
    {
        ByteArrayOutputStream out = null;
        try
        {
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM_RSA)
                    .generatePrivate(new PKCS8EncodedKeySpec(privateKey));
            Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION_RSA);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] encryptedData = content;
            int inputLen = encryptedData.length;
            out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0)
            {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK)
                {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                }
                else
                {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();

            return decryptedData;
        }
        catch (Exception e)
        {
            throw new Exception("error occured in decrypt.", e);
        }
        finally
        {
            IOUtil.closeQuietly(out);
        }
    }


    /**
     * RSA 私钥解密
     * 
     * @param content 密文（字节数组）
     * @param privateKeyBase64Str 私钥（BASE64加密的私钥字符串）
     * @param charset 字符集（默认UTF-8）
     * @return 明文（字节数组）
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, String privateKeyBase64Str, String charset) throws Exception
    {
        if (charset == null || "".equals(charset))
        {
            charset = CHARSET_UTF8;
        }
        byte[] encryptedData = Base64.decodeBase64(content);
        byte[] keyBytes = Base64.decodeBase64(privateKeyBase64Str.getBytes(charset));
        return decrypt(encryptedData, keyBytes);
    }


    /**
     * RSA 私钥解密
     * 
     * @param content 密文
     * @param privateKeyBase64Str 私钥（BASE64加密的私钥字符串）
     * @param charset 字符集（默认UTF-8）
     * @return
     * @throws Exception
     */
    public static String decrypt(String content, String privateKeyBase64Str, String charset) throws Exception
    {
        if (charset == null || "".equals(charset))
        {
            charset = CHARSET_UTF8;
        }
        byte[] encodeBase64Data = content.getBytes(charset);
        byte[] decryptedData = decrypt(encodeBase64Data, privateKeyBase64Str, charset);
        return new String(decryptedData, charset);
    }


    /**
     * 加密文件
     * 
     * @param srcFile 源文件（字符串）
     * @param tmpPath 加密后文件存放路径
     * @param key 密钥
     * @param charset 字符集
     * @return 加密后的文件
     * @throws Exception
     */
    public static File encryptFile(String srcFile, String tmpPath, String key, String charset) throws Exception
    {
        return encryptFile(new File(srcFile), tmpPath, key, charset);
    }


    /**
     * 加密文件
     * 
     * @param srcFile 源文件
     * @param tmpPath 加密后文件存放路径
     * @param key 密钥
     * @param charset 字符集
     * @return 加密后的文件
     * @throws Exception
     */
    public static File encryptFile(File srcFile, String tmpPath, String key, String charset) throws Exception
    {

        if (!srcFile.exists())
        {
            throw new FileNotFoundException("未找到指定文件");
        }

        FileInputStream fis = new FileInputStream(srcFile);
        int fileSize = fis.available();
        if (fileSize == 0)
        {
            fis.close();
        }

        File newFile = new File(tmpPath + File.separator + srcFile.getName());
        if (!newFile.getParentFile().exists())
        {
            newFile.getParentFile().mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(newFile);
        byte[] buf = new byte[fileSize];
        byte[] encryptedBuf;
        while (fis.read(buf) != -1)
        {
            encryptedBuf = encrypt(buf, key, charset);
            fos.write(encryptedBuf);
        }
        fos.close();
        fis.close();

        return newFile;
    }


    /**
     * 解密文件
     * 
     * @param srcFile 源文件
     * @param tmpPath 解密后文件存放路径
     * @param key 密钥
     * @param charset 字符集
     * @return 解密后的文件
     * @throws Exception
     */
    public static File decryptFile(String srcFile, String tmpPath, String key, String charset) throws Exception
    {
        return decryptFile(new File(srcFile), tmpPath, key, charset);
    }


    /**
     * 解密文件
     * 
     * @param srcFile 源文件
     * @param tmpPath 解密后文件存放路径
     * @param key 密钥
     * @param charset 字符集
     * @return 解密后的文件
     * @throws Exception
     */
    public static File decryptFile(File srcFile, String tmpPath, String key, String charset) throws Exception
    {

        if (!srcFile.exists())
        {
            throw new FileNotFoundException("未找到指定文件");
        }

        FileInputStream fis = new FileInputStream(srcFile);
        int fileSize = fis.available();
        if (fileSize == 0)
        {
            fis.close();
        }

        File newFile = new File(tmpPath + File.separator + srcFile.getName());
        if (!newFile.getParentFile().exists())
        {
            newFile.getParentFile().mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(newFile);
        byte[] buf = new byte[fileSize];
        byte[] decryptStr;
        while (fis.read(buf) != -1)
        {
            decryptStr = decrypt(buf, key, charset);
            fos.write(decryptStr);
        }
        fos.close();
        fis.close();

        return newFile;
    }


    /**
     * 将特殊字节数组转换为16进制字符串
     * 
     * @param bcd
     * @return
     */
    public static final String bytesToHexStr(byte[] bcd)
    {
        StringBuffer s = new StringBuffer(bcd.length * 2);
        for (int i = 0; i < bcd.length; i++)
        {
            s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
            s.append(bcdLookup[bcd[i] & 0x0f]);
        }
        return s.toString();
    }


    /**
     * 将16进制字符串转换为特殊字节数组
     * 
     * @param s
     * @return
     */
    public static final byte[] hexStrToBytes(String s)
    {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++)
        {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
