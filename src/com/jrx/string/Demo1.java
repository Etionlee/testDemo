//*****************************************************************************
//
// File Name       :  com.jrx.string.Demoo1
// Date Created    :  2020/3/18
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/3/18
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.string;

/**
 * Created by Etionlee on 2020/3/18.
 */
public class Demo1
{
    public static void main(String[] args)
    {
        String line = "2020-04-02|F021009001002005|LOANAP202004021623220069154870|2020040221169107|null|2020-04-02 16:24:17|2020-07-05|测*贷|530***********0159|3100.00000|207|0.0531000000|3|02|3129.08|1|2020-05-05|1028.70|15.09|0.00#2|2020-06-05|1033.33|9.32|0.00#3|2020-07-05|1037.97|4.67|0.00|";

        String lineArr[] = line.split("\\|");
        // 以首期期数加还款日查找索引
        String flag = lineArr[15] + "|" + lineArr[16];
        String planStr = line.substring(line.indexOf(flag), line.lastIndexOf("|"));
        String planArr[] = planStr.split("#");
        for (String plan : planArr)
        {
            String arr[] = plan.split("\\|");
            System.out.println("第" + arr[0] + "期，还款日：" + arr[1] + "，本金：" + arr[2] + "，利息：" + arr[3] + "，费用：" + arr[4]);
        }

    }

}
