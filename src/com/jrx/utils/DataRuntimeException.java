package com.jrx.utils;

public class DataRuntimeException extends RuntimeException
{
    public DataRuntimeException(Exception e)
    {
        super(e);
    }


    public DataRuntimeException(String e)
    {
        super(e);
    }
}
