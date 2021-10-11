package T.lock2;

import T.volatile_01.T;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * unpark可以先于park调用
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 11:27
 */
public class T02_TestLockSupport {

    private List<String> list = new ArrayList<>();

    private void add(String s) {
        list.add(s);
    }

    private int size() {
        return list.size();
    }

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        T02_TestLockSupport t = new T02_TestLockSupport();

        t2 = new Thread(() -> {
            System.out.println("t2 start");
            LockSupport.park();
            System.out.println("t2 end");
            LockSupport.unpark(t1);
        });

        t1 = new Thread(() -> {
            System.out.println("T1 start");
            for (int i = 0; i < 10; i++) {
                t.add(i + "");
                System.out.println("add " + i);
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });


        t1.start();
        t2.start();

    }
}
