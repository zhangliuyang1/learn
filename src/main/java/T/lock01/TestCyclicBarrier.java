package T.lock01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 17:12
 */
public class TestCyclicBarrier {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> System.out.println("满人，发车"));

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println(finalI);
                    cyclicBarrier.await();
                    System.out.println("await:"+ finalI);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("end");
    }
}
