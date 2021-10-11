package T.lock2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印AB 的三种写法
 * 1、wait && notify  synchronized
 * 2、condition wait signal   ReentrantLock
 * 3、LockSupport.park unPark
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 11:32
 */
public class T03_PrintAB {

    public static void main(String[] args) {

//        notifyAndWait();

//        printWithReentrantLock();

        printWithLockSupport();
    }

    static Thread t1 = null;
    static Thread t2 = null;
    private static void printWithLockSupport(){
        t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("A");
                LockSupport.park();
                LockSupport.unpark(t2);
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("B");
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });
        t1.start();
        t2.start();
    }


    private static void printWithReentrantLock() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("A");
                try {
                    condition.await();
//                    System.out.println("A 释放锁，进入等待状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition.signal();
//                System.out.println("B  被唤醒");

            }
            lock.unlock();
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("B");
                condition.signal();
//                System.out.println("A  被唤醒");
                try {
                    condition.await();
//                    System.out.println("B 释放锁，进入等待状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        });

        t1.start();
        t2.start();

    }


    private static void notifyAndWait() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("A");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("B");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();

                }
            }
        });
        t2.start();
        t1.start();
    }

}
