package T.volatile_01;

/**
 * volatile
 * 1.保证线程可见性
 * 2.禁止指令重排序
 *  ——DCL单例模式
 *  - Double Check Lock
 *  -
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 14:12
 */
public class T {

    private static boolean flag = true;


    public static void exe(){
        while (flag){
            System.out.println("111");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag){
                System.out.println("1111");
            }
        },"t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> flag = false).start();


    }
}
