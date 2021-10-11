package bitoperation;

/**
 * and运算 & ：按位与：相同位的两个数字都为1，则为1；若有一个不为1，则为0
 * or运算 ｜：按位或：相同位的两个数字只要一个为1即为1
 * xor运算 ^ ：按位异或：相同位不同则为1，相同则为0
 * ~ ：按位取反：
 *
 * @Author: zhangliuyang01
 * @Date: 2021/2/19 上午11:10
 */
public class App {

    public static void main(String[] args) {
        long a = 8;
        long b = 6;
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toBinaryString(b));

        System.out.println("a&b="+Long.toBinaryString(a & b));
        System.out.println("a|b="+Long.toBinaryString(a | b));
        System.out.println("a^b="+Long.toBinaryString(a ^ b));

    }
}
