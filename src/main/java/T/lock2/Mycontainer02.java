package T.lock2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 18:42
 */
public class Mycontainer02<T> {

    private LinkedList<T> list = new LinkedList<>();

    private static int MAX = 10;

    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    private void put(T t){
        lock.lock();
        try {
            while (list.size() == MAX){
                producer.await();
            }
            list.add(t);
            count++;
            consumer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private T get(){
        T t = null;
        lock.lock();
        try {
            while (list.size() == 0){
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }
}
