package com.jrx.sign;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil
{

    private static String SUFFIX_ZIP = ".zip";


    /**
     * 压缩文件
     * 
     * @param srcFiles 源文件集
     * @param targetPath 目标路径
     * @param targetFileName 目标压缩文件名
     * @return
     */
    public static File compress(List<File> srcFiles, String targetPath, String targetFileName)
    {
        File target = new File(targetPath, targetFileName + SUFFIX_ZIP);
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        FileOutputStream fos = null;
        int BUFFER_SIZE = 2 * 1024;
        try
        {
            fos = new FileOutputStream(target);
            zos = new ZipOutputStream(new BufferedOutputStream(fos));
            for (File srcFile : srcFiles)
            {
                byte[] buf = new byte[BUFFER_SIZE];
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1)
                {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        }
        catch (Exception e)
        {
            throw new RuntimeException("zip error from ZipUtil", e);
        }
        finally
        {
            IOUtil.closeQuietly(zos, fos);
        }

        return target;
    }


    /**
     * 压缩文件夹
     * 
     * @param srcPath 源文件夹
     * @param targetPath 目标路径
     * @param targetFileName 目标压缩文件名
     * @return
     */
    public static File compress(String srcPath, String targetPath, String targetFileName)
    {
        File source = new File(srcPath);
        if (source.exists() && source.isDirectory())
        {
            List<File> srcFiles = new ArrayList<>();
            for (File file : source.listFiles())
            {
                if (!file.isDirectory())
                {
                    srcFiles.add(file);
                }
            }
            return compress(srcFiles, targetPath, targetFileName);
        }
        return null;
    }


    /**
     * 解压文件
     * 
     * @param srcFile 源文件
     * @param targetPath 解压路径
     */
    public static void unzip(String srcFile, String targetPath)
    {
        long start = System.currentTimeMillis();
        File source = new File(srcFile);
        if (source.exists())
        {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try
            {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while ((entry = zis.getNextEntry()) != null && !entry.isDirectory())
                {
                    File target = new File(targetPath, entry.getName());
                    if (!target.exists())
                    {
                        // 创建文件父目录
                        target.getParentFile().mkdirs();
                    }
                    // 写入文件
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1)
                    {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
                long end = System.currentTimeMillis();
                System.out.println("解压缩完成，耗时：" + (end - start) + " ms");
            }
            catch (IOException e)
            {
                throw new RuntimeException("unzip error from ZipUtil", e);
            }
            finally
            {
                IOUtil.closeQuietly(zis, bos);
            }
        }
    }


    /**
     * 解压文件
     * 
     * @param srcFile 源文件
     */
    public static void unzip(String srcFile)
    {
        String targetPath = srcFile.substring(0, srcFile.lastIndexOf("/"));
        unzip(srcFile, targetPath);
    }


    /**
     * 压缩文件夹并加密文件
     * 
     * @param srcPath 源文件夹
     * @param targetPath 目标路径
     * @param targetFileName 目标压缩文件名
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws Exception
     */
    public static File compressAndEncrypt(String srcPath, String targetPath, String targetFileName, String key,
            String charset) throws Exception
    {
        File target = compress(srcPath, targetPath, targetFileName);
        return RSAUtil.encryptFile(target, targetPath, key, charset);
    }


    /**
     * 压缩文件集并加密文件
     * 
     * @param srcFiles 源文件集
     * @param targetPath 目标路径
     * @param targetFileName 目标压缩文件名
     * @param publicKey RSA公钥
     * @param charset 字符集
     * @return
     * @throws Exception
     */
    public static void compressAndEncrypt(List<File> srcFiles, String targetPath, String targetFileName,
            String publicKey, String charset) throws Exception
    {
        File target = compress(srcFiles, targetPath, targetFileName);
        RSAUtil.encryptFile(target, targetPath + File.separator + "encrypt", publicKey, charset);
        target.delete();
    }


    /**
     * 解密并解压文件
     * 
     * @param srcFile 源文件
     * @param targetPath 目标文件夹
     * @param privateKey RSA私钥
     * @param charset 字符集
     * @throws Exception
     */
    public static void decryptAndUnzip(String srcFile, String targetPath, String privateKey, String charset)
            throws Exception
    {
        File decryptedFile = RSAUtil.decryptFile(srcFile, targetPath, privateKey, charset);
        unzip(decryptedFile.getAbsolutePath());
        decryptedFile.delete();
    }
}
