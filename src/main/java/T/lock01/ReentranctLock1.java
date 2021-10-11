package T.lock01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 16:31
 */
public class ReentranctLock1 {

    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
