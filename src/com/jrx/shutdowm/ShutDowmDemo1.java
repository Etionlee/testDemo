//*****************************************************************************
//
// File Name       :  com.jrx.shutdowm.ShutDowmDemo1
// Date Created    :  2020/4/14
// Last Changed By :  Author: Etionlee
// Last Changed On :  Date: 2020/4/14
// Revision        :  Rev: 1.0.0
// Description     :  //TODO To fill in a brief description of the purpose of
//                    this class.
//
// XiTai Pte Ltd.  Copyright (c) 2020.  All Rights Reserved.
//
//*****************************************************************************
package com.jrx.shutdowm;

/**
 * Created by Etionlee on 2020/4/14.
 */
public class ShutDowmDemo1
{

    public static void main(String[] args)
    {
        System.out.println("1: Main start");

        Thread mainThread = Thread.currentThread();

        // 注册一个 ShutdownHook
        ShutdownSampleHook thread = new ShutdownSampleHook(mainThread);
        Runtime.getRuntime().addShutdownHook(thread);

        try
        {
            Thread.sleep(10 * 1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("3: mainThread get interrupt signal.");
        }

        System.out.println("4: Main end");
    }
}

class ShutdownSampleHook extends Thread
{
    private Thread mainThread;


    @Override
    public void run()
    {
        System.out.println("2: Shut down signal received.");
        mainThread.interrupt();// 给主线程发送一个中断信号
        try
        {
            mainThread.join(); // 等待 mainThread 正常运行完毕
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("5: Shut down complete.");
    }


    public ShutdownSampleHook(Thread mainThread)
    {
        this.mainThread = mainThread;

    }
}