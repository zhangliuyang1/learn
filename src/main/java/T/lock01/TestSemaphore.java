package T.lock01;

import java.util.concurrent.Semaphore;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 18:22
 */
public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T1 head running...");
                Thread.sleep(200);
                System.out.println("T1 tail running...");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();


        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("T2 head  running...");
                Thread.sleep(200);
                System.out.println("T2 tail running...");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();


    }
}
