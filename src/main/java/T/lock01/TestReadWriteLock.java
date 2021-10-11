package T.lock01;

import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 18:14
 */
public class TestReadWriteLock {

    ReentrantLock lock = new ReentrantLock();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();



    void  m1(){

    }




}
