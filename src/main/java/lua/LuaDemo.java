package lua;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/9/15 上午11:14
 */
public class LuaDemo {


    public static void main(String[] args) {
        long a = 10;
        int b = 20;
        System.out.println(a < b);
        System.out.println(System.getProperty("user.dir"));

        long localId  = 120100000000L;
        String localIdStr = localId + "";
        System.out.println(localIdStr.substring(0, 2));


    }
}
