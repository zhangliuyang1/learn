package threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import sun.print.PrintJob2D;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/4/28 上午11:23
 */
public class PoolTest {

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            private AtomicInteger atomicInteger = new AtomicInteger(0);
            private String name = "pooltest";

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(name + atomicInteger.incrementAndGet());
                return thread;
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(100), new NamedThreadFactory("pool-test-%d", true)
                , new ThreadPoolExecutor.DiscardOldestPolicy());


        for (int i = 0; i < 100000; i++) {
            executor.submit(new Print(i));
        }
//        new Thread(() ->{
//
//        });



//        while (true){
//            new Thread(() -> {
//                int activeCount = executor.getActiveCount();
//                long taskCount = executor.getTaskCount();
//                long completedTaskCount = executor.getCompletedTaskCount();
//                System.out.println("activeCount=" + activeCount);
//                System.out.println("taskCount=" + taskCount);
//                System.out.println("completedTaskCount=" + completedTaskCount);
//            }).start();
//        }


    }


    private static class Print implements Runnable {

        private int i;

        public Print(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
