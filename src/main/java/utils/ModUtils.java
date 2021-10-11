package utils;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/6/29 18:03
 */
public class ModUtils {


    public static void main(String[] args) {
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(System.currentTimeMillis() & 14);
//        }


        long a = 56653184755726L;
        System.out.println(Math.floorMod(a,16));
        System.out.println(a % 16);

    }
}
