package threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/5/26 下午5:33
 */
public class NamedThreadFactory implements ThreadFactory {

    private String nameFormat;
    private boolean damon;

    public NamedThreadFactory(String nameFormat,boolean damon) {
        // fail fast if the format is bad or null
        String unused = String.format(nameFormat, 0);
        this.nameFormat = nameFormat;
        this.damon = damon;
    }

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(String.format(nameFormat,count.getAndIncrement()));
        thread.setDaemon(damon);
        return thread;
    }
}
