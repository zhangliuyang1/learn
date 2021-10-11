package T.volatile_01;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile  不保证原子性
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 15:02
 */
public class T1 {

    volatile int count = 0;
    synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T1 t = new T1();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-" + i));
        }
        threads.forEach(o -> o.start());

        threads.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
