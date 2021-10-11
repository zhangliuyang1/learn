package io;


import java.io.*;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/6/1 下午7:55
 */
public class InputStreamDemo {

    public static void main(String[] args) throws Exception {
        String path = "/Users/liuyangzhang/Documents/58/project/learn/pom.xml";


        System.out.println(readIns(path));
        System.out.println("*******************************");
        System.out.println(readBr(path));
    }

    /**
     * 字节流
     * @param file
     * @return
     */
    private static String readIns(String file){
        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = new FileInputStream(file);
            byte[] bytes = new byte[1024];

            int read = is.read(bytes);
            while (read != -1) {
                sb.append(new String(bytes));
                bytes = new byte[1024];
                read = is.read(bytes);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 字伏流
     * @param file
     * @return
     */
    private static String readBr(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
