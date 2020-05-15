//*****************************************************************************
//
// File Name       :  com.jrx.BigDecimalDemo.BigDecimalDemo1
// Date Created    :  2019/11/13
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/11/13
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.BigDecimalDemo;

import java.math.BigDecimal;

/**
 * Created by Etionlee on 2019/11/13.
 */
public class BigDecimalDemo1
{
    public static void main(String[] args)
    {
        String kedLimit = "20.22"; // 快E贷额度
        String sedLimit = "20.22"; // 税E贷额度

        String kedRate = "1.3324"; // 快E贷利率
        String sedRate = "1.3323"; // 税E带利率

        System.out.println(new BigDecimal(kedLimit).compareTo(new BigDecimal(sedLimit)));
        System.out.println(Double.valueOf(kedRate) >= Double.valueOf(sedRate));

    }
}
