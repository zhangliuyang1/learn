package T.lock2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 10:59
 */
public class T01_TestCountLatch {
    private List<String> list = new ArrayList<>();

    private void add(String s){
        list.add(s);
    }

    private int size(){
        return list.size();
    }


    public static void main(String[] args) {

        T01_TestCountLatch t = new T01_TestCountLatch();
        CountDownLatch c1 = new CountDownLatch(1);
        CountDownLatch c2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");

            if (t.size() != 5){
                try {
                    c1.await();
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c2.countDown();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            System.out.println("T1 start");
            for (int i = 0; i < 10; i++) {
                t.add(i + "");
                System.out.println("add " + i);
                if (t.size() == 5){
                    c1.countDown();
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
