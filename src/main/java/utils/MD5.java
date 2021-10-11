package utils;

import java.security.MessageDigest;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/8/4 下午7:46
 */
public class MD5 {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public MD5() {
    }

    public static String getMD5(String src) {
        return getMD5(src.getBytes());
    }

    public static long getMD5(String src, int lastBits) {
        lastBits /= 8;
        byte[] bs = getMD5Bytes(src);
        long sum = 0L;

        for(int i = bs.length - 1; i >= bs.length - lastBits; --i) {
            sum += (long)(255 & bs[i]);
        }

        return sum;
    }

    public static String getMD5(byte[] src) {
        String ret = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src);
            byte[] tmp = md.digest();
            char[] str = new char[tmp.length * 2];
            int k = 0;

            for(int i = 0; i < tmp.length; ++i) {
                byte b = tmp[i];
                str[k++] = hexDigits[b >>> 4 & 15];
                str[k++] = hexDigits[b & 15];
            }

            ret = new String(str);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return ret;
    }

    public static byte[] getMD5Bytes(String src) {
        MessageDigest md = null;
        byte[] encryptMsg = null;

        try {
            md = MessageDigest.getInstance("MD5");
            encryptMsg = md.digest(src.getBytes());
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return encryptMsg;
    }

    public static void main(String[] args) {
        String a = "sdfdsfdglkdfsgkieworjoijgisdfsda";
        System.out.println(getMD5(a));
    }
}
