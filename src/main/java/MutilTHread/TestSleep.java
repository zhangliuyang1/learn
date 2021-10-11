package MutilTHread;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/27 18:32
 */
public class TestSleep {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread((() -> {
            synchronized (lock){
                try {
                    System.out.println("t1 sleep 2s");
                    Thread.sleep(10000);

                    System.out.println("===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        })).start();

        new Thread(() -> {
            synchronized (lock){
                System.out.println("t2");
            }
        }).start();


        new Thread(() -> {
            System.out.println("t3");
        }).start();

    }
}
