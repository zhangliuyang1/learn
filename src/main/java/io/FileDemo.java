package io;

import java.io.File;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/1 下午7:38
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("/Users/liuyangzhang/Documents");
        String[] list = file.list();
        File[] files = file.listFiles();
        System.out.println(file.getTotalSpace()/(1024 * 1024 * 1024));
        File absoluteFile = file.getAbsoluteFile();
        String absolutePath = file.getAbsolutePath();


        System.out.println(files);
    }
}
