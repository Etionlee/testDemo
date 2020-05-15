//*****************************************************************************
//
// File Name       :  com.jrx.demo.Demo2
// Date Created    :  2019/1/4
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/1/4
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.demo;

/**
 * Created by Etionlee on 2019/1/4.
 */
public class Demo2
{
    public static void main(String[] args)
    {
        String loanMoney = "1002.3";
        Double money = Double.valueOf(loanMoney);
        Integer loanMoneyPercent = 1;
        System.out.println(money % loanMoneyPercent);
        System.out.println(money % loanMoneyPercent != 0);
        System.out.println(!loanMoney.matches("[0-9]+"));

    }
}
