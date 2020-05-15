package com.jrx.file;

import java.io.File;

/**
 * @Description
 * @Author liyx
 * @CreateDate 2020/4/21
 * @Version
 */
public class FileDemo1
{
    public static void main(String[] args)
    {
        File file = new File("/app/anysale/file/fenqile_sit/repayments/20210527/20210527_repayments.dat");

        if (null != file && file.exists() && file.isFile())
        {
            System.out.println("分期乐还款文件:{},下载成功，开始启动job...");

        }
        else
        {
            System.out.println("分期乐还款文件下载未完成");
        }
    }
}
