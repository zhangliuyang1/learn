import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/4/29 下午5:10
 */
public class StringTest {

    public static void main(String[] args) {
//        String a = "ALTER TABLE `t_wallet_record_%d` ADD INDEX idx_uid_timestamp ( `uid`, `record_timestamp`);";
//
//        String b = "ALTER TABLE `t_wallet_record_%d` ADD INDEX idx_uid_sourcecode_record_time ( `uid`, `source_code`, `record_time` );";
//        for (int i = 0; i < 32; i++) {
//            System.out.println(String.format(a, i));
//        }
//
//        System.out.println("======");
//        for (int i = 0; i < 32; i++) {
//            System.out.println(String.format(b, i));
//        }

        System.out.println("main thread start");
        List<Integer> list = new ArrayList<>();
        int num = 100;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CyclicBarrier barrier = new CyclicBarrier(num+1);

        final int[] count = {0};
        new Thread(()->{
            for (int i = 0; i < num; i++) {
                int finalI = i;
                new Thread(() -> {
                    try {
                        System.out.println("ready="+finalI);
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    try {
                        list.add(finalI);
                        System.out.println("add = " + finalI);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

//                System.out.println(count[0]++);
//                countDownLatch.countDown();
                }).start();
            }
            countDownLatch.countDown();

        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        countDownLatch.countDown();

        System.out.println("child thread start");

        //            boolean await = countDownLatch.await(1, TimeUnit.SECONDS);
//            System.out.println(await);
//            countDownLatch.await();

        System.out.println("main thread end");

        System.out.println("list.size="+list.size());
    }
}
