package parseq;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/8/25 15:14
 */
public class ParseqThreadFactory implements ThreadFactory {

    private ThreadGroup group;
    private AtomicInteger count = new AtomicInteger(0);

    public ParseqThreadFactory(String groupName) {
        group = new ThreadGroup(groupName);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(group, r);
        thread.setName(String.format(group.getName(),count.incrementAndGet()));
        return thread;
    }
}
