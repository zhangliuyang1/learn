package T.lock2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 17:59
 */
public class T04_TestSemaphore {

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
        T04_TestSemaphore t = new T04_TestSemaphore();

    }
}
