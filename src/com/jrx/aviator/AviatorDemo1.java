//*****************************************************************************
//
// File Name       :  com.jrx.aviator.AviatorDemo1
// Date Created    :  2019/10/22
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2019/10/22
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2019.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * Created by Etionlee on 2019/10/22.
 */
public class AviatorDemo1
{
    public static void main(String[] args)
    {
        if (!AviatorEvaluator.containsFunction("math.max"))
        {
            AviatorEvaluator.addFunction(new MathMaxFunction());
        }
        if (!AviatorEvaluator.containsFunction("ln"))
        {
            AviatorEvaluator.addFunction(new LnFunction());
        }
        if (!AviatorEvaluator.containsFunction("log"))
        {
            AviatorEvaluator.addFunction(new LogFunction());
        }
        Expression expressionA = AviatorEvaluator.compile("math.max(10,11)");
        Object resultA = expressionA.execute();
        System.out.println("resultA=" + resultA);

        Expression expressionB = AviatorEvaluator.compile("ln(3)");
        Object resultB = expressionB.execute();
        System.out.println("resultB=" + resultB);

        Expression expressionC = AviatorEvaluator.compile("log(103)");
        Object resultC = expressionC.execute();
        System.out.println("resultC=" + resultC);

        Expression expressionD = AviatorEvaluator.compile("1+1");
        Object resultD = expressionD.execute();
        System.out.println("resultD=" + resultD);
    }
}
