//*****************************************************************************
//
// File Name       :  com.jrx.sign.Demo
// Date Created    :  2019/10/9
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/10/9
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.sign;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Etionlee on 2019/10/9.
 */
public class Demo1FileRSA
{
    public static void main(String[] args) throws Exception
    {

        // Map<String, String> map = RSAUtil.genKeyPair();
        // System.out.println("publicKeyBase64Str:" + map.get("publicKeyBase64Str"));
        // System.out.println("privateKeyBase64Str:" + map.get("privateKeyBase64Str"));

        String publicKeyBase64Str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQClo+PtiyfWuhyuBYdsc8JtOe6lCTHB8Qr0q2jZI0w1arL1qDJ6P5G5/v8mIU0EUO8TbL+H2aEldjS3Rf4pSdljfWx+4pwDu3svi7B5CU/b1RblXc3c+O/LrHt4U9tRYRpoVyZIM8UrV479P/EirYbe+L+bgJf9c0INa+FCnsQmXQIDAQAB";
        String privateKeyBase64Str = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKWj4+2LJ9a6HK4Fh2xzwm057qUJMcHxCvSraNkjTDVqsvWoMno/kbn+/yYhTQRQ7xNsv4fZoSV2NLdF/ilJ2WN9bH7inAO7ey+LsHkJT9vVFuVdzdz478use3hT21FhGmhXJkgzxStXjv0/8SKtht74v5uAl/1zQg1r4UKexCZdAgMBAAECgYACb7q2j8lyOyKY3LP1QG6ntKZx/wSgWa9TkgHkz8QbNQqU2niDm9PE7J9MLEk5uwcJPhxDH0xjhK2Z1Im8ib2M1wEHAA/YsakHPYUr06oT+/UVh7A53t7R3WqlRzLq+7aEGTWbtoNyR5G2Hh3nih+flNMJQ+EvrTaOiuzfcYii8QJBAONQomR/eZMud8xmIVAVTbNJmAcz98E5TyeGB5bFAZVxSnqd77UOQABSWGVystRnIXZ1vfIEW0UZHS87LWOzAxMCQQC6it1D/pig8BBMdYltTcTT+YVukPvDvsoACwgmMmmnJXLp43QUtrVti90yp2yna8TTYs3pR0Ug0eZIfRa3U+7PAkAwUA4DwBgt0P2DQt2nsK9wAJ9AQKpStgR9yP3J7Js2kPqcbv7og1vU9at1/FfHzxeMnt+9FXH0kK7kP/aYrw5jAkAcJoyRkEA0OUYcY7hjeFL1sjgCoXp85bPSIdgO+5iaErqutRZ1ccUbTPoKhN2OvmKri8OLKqgx9bsMwWPGMrJdAkBDHh6/oTrU5h4n0shxS9UeUQbFYIfjQb6Xe5WHb/qwNDnn5rUDVDe2qtQotCsRtpAhz+852ikNDVp1ZpkbzdgP";

        // 压缩
        // 被压缩文件路径
        List<File> files = new ArrayList<>();
        files.add(new File("/Users/Etionlee/Desktop/zip/cr_lmt.txt"));
        // 压缩后文件目录
        String targetPath = "/Users/Etionlee/Desktop/zip/";
        // 压缩后文件名称
        String targetFileName = "cr_lmt";
        ZipUtil.compressAndEncrypt(files, targetPath, targetFileName, publicKeyBase64Str, RSAUtil.CHARSET_UTF8);


        // 解压
        // 被解压文件路径
        String srcFile = "/Users/Etionlee/Desktop/zip/encrypt/cr_lmt.zip";
        // 解压后文件目录
        String srcTargetPath = targetPath + File.separator + "decrypt";
        ZipUtil.decryptAndUnzip(srcFile, srcTargetPath, privateKeyBase64Str, RSAUtil.CHARSET_UTF8);

    }

}
