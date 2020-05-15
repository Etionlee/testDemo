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
public class LnFunction extends AbstractFunction
{

    public static final String NAME = "ln";


    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1)
    {
        Object obj1 = arg1.getValue(env);
        if (obj1 != null)
        {
            Number num1 = FunctionUtils.getNumberValue(arg1, env);
            return new AviatorDouble(Math.log(num1.doubleValue()) );
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
