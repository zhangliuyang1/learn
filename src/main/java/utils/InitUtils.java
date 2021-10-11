package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/6 19:16
 */
public class InitUtils {


    public static String a = "hello";

    public static void update() {
        a = "world";
    }


    static {
        init();
    }


    public static Map<String, String> map = new HashMap<>();


    /**
     * 变量定义一定 要 先于 static静态方法（当此方法会改变此变量时）
     */
    public static Map<String, String> map2 = new HashMap<>();

    static {
        init2();
    }

    public static void init() {
        if (map == null) {
            map = new HashMap<>();
        }

        map.put("a", "b");
    }

    public static void init2() {
        if (map2 == null) {
            map2 = new HashMap<>();
        }

        map2.put("a", "b");
    }

    public static Map getMap() {
        return map;
    }


    public static String getValue(String key) {
        return map.get(key);
    }
}
