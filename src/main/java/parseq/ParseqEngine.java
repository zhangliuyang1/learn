package parseq;

import com.linkedin.parseq.Engine;
import com.linkedin.parseq.EngineBuilder;
import com.linkedin.parseq.Task;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/25 14:53
 */
public class ParseqEngine {

    private static ExecutorService executorService;
    private static ScheduledExecutorService scheduledExecutorService;
    private static Engine engine;

    public static void init() {
        int numCors = Runtime.getRuntime().availableProcessors();
        executorService = new ThreadPoolExecutor(numCors + 1, numCors + 1, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000), new ThreadFactory() {
            private ThreadGroup group = new ThreadGroup("parseq-thead-pool-%s");
            private AtomicInteger atomicInteger = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(group, r);
                thread.setName(String.format(group.getName(), atomicInteger.getAndDecrement()));
//                System.out.println(thread.getName());
                return thread;
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        EngineBuilder engineBuilder = new EngineBuilder().setTaskExecutor(executorService).setTimerScheduler(scheduledExecutorService);
        engine = engineBuilder.build();
        shutdownHook();
    }


    public static <T> T run(Task<T> task) {
        return runAndWait(task, 40000, TimeUnit.MILLISECONDS);
    }


    public static <T> T runAndWait(Task<T> task, long l, TimeUnit unit) {
        engine.run(task);
        try {
            task.await(l, unit);
            return task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void shutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Parseq shutdown");
            engine.shutdown();
            try {
                engine.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
                scheduledExecutorService.shutdown();
            }
        }));
    }
}
