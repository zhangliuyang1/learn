package T.lock2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/20 15:15
 */
public class T05_Print {


    public static void main(String[] args) {

//        printWithSync();
//        printWithLockSupport();
        printWithLock();

    }

    static Thread t1;
    static Thread t2;

    private static void printWithLockSupport(){

        t1 = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                System.out.println(i);
                LockSupport.unpark(t2);
                LockSupport.park();

            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                char a = (char) ('A' + i);
                System.out.println(a);
                LockSupport.unpark(t1);
                LockSupport.park();

            }
        });
        t2.start();
        t1.start();


    }


    private static void printWithSync(){
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock){
                for (int i = 1; i < 27; i++) {
                    System.out.println(i);

                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i < 26; i++) {
                    char a = (char) ('A' + i);
                    System.out.println(a);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        });

        t1.start();
        t2.start();

    }


    private static void printWithLock(){
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            for (int i = 1; i <= 26; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                c2.signal();
                try {
//                    condition.signal();
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            c2.signal();
            lock.unlock();
        },"t1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 25; i++) {
                char a = (char)('A'+i);
                System.out.println(Thread.currentThread().getName() + ":" + a);
                c1.signal();
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            c1.signal();
            lock.unlock();
        },"t2");

        t1.start();
        t2.start();

    }

}
