package T.lock01;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 17:01
 */
public class TestCountDownLatch {


    public static void main(String[] args) {
        countDownLatch();
    }


    public static void countDownLatch(){
        Thread[] threads = new Thread[5];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
//                int result = 0;
//                for (int j = 0; j < 10000; j++) {
//                    result += j;
//                    countDownLatch.countDown();
//                }
                System.out.println(finalI);
                countDownLatch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" main ");


        new Thread(() -> {
            System.out.println("aaa");
        }).start();
    }
}
