package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/6 19:18
 */
public class App {


    private static String b = InitUtils.a;


    public static void main(String[] args) {

        System.out.println(b);
        System.out.println(InitUtils.a);
        InitUtils.update();
        System.out.println(b);
        System.out.println(InitUtils.a);
    }
}
