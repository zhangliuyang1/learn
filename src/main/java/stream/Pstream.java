package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/12/30 下午8:30
 */
public class Pstream {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        list.parallelStream().forEach(a ->{
            Thread thread = Thread.currentThread();
            System.out.println("currentThread = " + thread.getClass().getName() + "-" + thread.getName() + "-" + thread.getId());
            ForkJoinWorkerThread workerThread = (ForkJoinWorkerThread) thread;
            ForkJoinPool pool = workerThread.getPool();
            int poolSize = pool.getPoolSize();
            int poolIndex = workerThread.getPoolIndex();
        });
    }
}
