package T.CAS;

import T.volatile_01.T;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 15:22
 */
public class T01_AtomicInteger {


    AtomicInteger count = new AtomicInteger(0);

    void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();// count++;
        }
    }


    public static void main(String[] args) {
        T01_AtomicInteger t = new T01_AtomicInteger();


    }
}
