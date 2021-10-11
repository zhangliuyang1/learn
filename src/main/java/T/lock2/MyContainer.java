package T.lock2;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 18:18
 */
public class MyContainer<T> {

    private LinkedList<T> list = new LinkedList<>();

    private static int MAX = 10;

    private int count = 0;

    public synchronized void put(T t){
        while (list.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notify();
    }

    public synchronized T get(){
        T t = null;
        while (list.size() == 0){
            try {
                System.out.println("get wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }


    public static void main(String[] args) {
        MyContainer<String> c = new MyContainer<>();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            },"producer" + i).start();
        }

//        try {
//            TimeUnit.SECONDS.sleep(6);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            },"consumer" + i).start();
        }








    }
}
