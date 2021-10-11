package T.AQS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS 源码阅读
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 19:07
 */
public class TestReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        try {

        }catch (Exception e){

        }finally {
            lock.unlock();
        }


    }
}
