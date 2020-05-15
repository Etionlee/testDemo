//*****************************************************************************
//
// File Name       :  com.jrx.string.Demo2
// Date Created    :  2020/3/21
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/3/21
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.string;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Etionlee on 2020/3/21.
 */
public class Demo2
{
    public static void main(String[] args)
    {
        StringBuffer a = new StringBuffer("");
        System.out.println(a.substring(0,a.length()-1));
    }


    public static String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    //身份证前三后四脱敏
    public static String idEncrypt(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }


}

