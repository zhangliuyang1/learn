package SnowFlake;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/2/18 下午4:56
 */
public class LongUtils {

    public static void main(String[] args) {

        long a = 5L;
        System.out.println(toBinary(a));

        a = a << 20;
        System.out.println(toBinary(a));

        long b = 8L;
        System.out.println(toBinary(b));
        b = b << 20;
        System.out.println(toBinary(b));


        long c = 10L;
        System.out.println(toBinary(c));

        System.out.println("====");
        long d = a | b | c;
        long e = a + b + c;

        System.out.println(toBinary(d));

        System.out.println(d);
        System.out.println(e);
    }


    public static String toBinary(long num) {
        StringBuilder binary = new StringBuilder(Long.toBinaryString(num));
        while (binary.length() < 64) {
            binary.insert(0, "0");
        }
        return binary.toString();
    }
}
