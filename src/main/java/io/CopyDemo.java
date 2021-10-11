package io;

import java.io.*;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/2 上午11:45
 */
public class CopyDemo {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        int readNum = 0;
        FileInputStream input = null;
        FileOutputStream out = null;
        try {
            input = new FileInputStream(new File("/Users/liuyangzhang/Documents/58/project/learn/src/main/java/io/InputstreamDemo.java"));
            out = new FileOutputStream(new File("/Users/liuyangzhang/Documents/58/project/learn/src/main/java/io/copy.txt"));

            while ((readNum = input.read(bytes)) != -1) {
                out.write(bytes, 0, readNum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void copyWithStream(String source, String dest) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] bytes = new byte[1024];
        int readNum = 0;
        while ((readNum = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, readNum);
        }
        bis.close();
        bos.close();
    }


    private void copyWith(String source, String dest) throws Exception {
        char[] chars = new char[1024];
        int readNum = 0;
//        FileReader fileReader = new FileReader(source);
//        FileWriter fileWriter = new FileWriter(dest);
//        while ((readNum = fileReader.read(chars)) != -1) {
//            fileWriter.write(chars, 0, readNum);
//        }
//        fileReader.close();
//        fileWriter.close();


        BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest));
        while ((readNum = bufferedReader.read(chars)) != -1) {
            bufferedWriter.write(chars, 0, readNum);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
