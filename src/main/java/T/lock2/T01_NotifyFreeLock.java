package T.lock2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 11:15
 */
public class T01_NotifyFreeLock {


    private List<String> list = new ArrayList<>();

    private void add(String s){
        list.add(s);
    }

    private int size(){
        return list.size();
    }


    public static void main(String[] args) {
        T01_NotifyFreeLock t = new T01_NotifyFreeLock();
        Object lock = new Object();

        Thread t1 = new Thread(() ->{
             synchronized (lock){
                 System.out.println("t1 start");
                 for (int i = 0; i < 10; i++) {
                     t.add(i + "");
                     System.out.println("add " + i);

                     if (t.size() == 5){
                         lock.notify();
                         try {
                             lock.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }
         });

         Thread t2 = new Thread(() -> {
             synchronized (lock){
                 System.out.println("t2 start");

                 if (t.size() != 5){
                     try {
                         lock.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 System.out.println("t2 end");
                 lock.notify();
             }
         });

         t2.start();
         t1.start();

    }
}
