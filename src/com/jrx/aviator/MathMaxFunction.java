package com.jrx.aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * math.max(d,d) function
 *
 * @author: hanchaoyong
 */
public class MathMaxFunction extends AbstractFunction
{

    public static final String NAME = "math.max";


    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2)
    {
        Object obj1 = arg1.getValue(env);
        Object obj2 = arg2.getValue(env);
        if (obj1 != null && obj2 != null)
        {
            Number num1 = FunctionUtils.getNumberValue(arg1, env);
            Number num2 = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorDouble(Math.max(num1.doubleValue(), num2.doubleValue()));
        }
        else
        {
            return new AviatorDouble(0D);
        }
    }


    @Override
    public String getName()
    {
        return NAME;
    }
}
