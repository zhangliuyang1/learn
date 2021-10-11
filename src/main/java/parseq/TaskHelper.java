package parseq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/25 17:27
 */
public class TaskHelper {

    private static ExecutorService executorService = new ThreadPoolExecutor(8, 16, 100,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
            new ParseqThreadFactory("common-pool-%s"),
            new ThreadPoolExecutor.CallerRunsPolicy());
}
