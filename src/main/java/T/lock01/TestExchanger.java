package T.lock01;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Exchanger;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 18:38
 */
public class TestExchanger {


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();


        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);
                System.out.println(Thread.currentThread().getName() +":"+ s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
                System.out.println(Thread.currentThread().getName() +":"+ s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }



}
