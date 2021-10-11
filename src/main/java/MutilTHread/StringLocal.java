package MutilTHread;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/7/5 下午7:53
 */
public class StringLocal {

    private static InheritableThreadLocal<String> stringLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        stringLocal.set("hello world");

        System.out.println(stringLocal.get());


        new Thread(() -> {
            String s = stringLocal.get();
            System.out.println(s);
        }).start();

    }

}
