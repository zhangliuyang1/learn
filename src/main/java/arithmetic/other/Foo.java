package arithmetic.other;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/9 22:15
 */
public class Foo {



    public Foo() {

    }

    public void first() {


        System.out.println("first");
    }

    public void second() {

        System.out.println("second");

    }

    public void third() {

        System.out.println("third");

    }


    public static void main(String[] args) throws Exception{
        CountDownLatch one = new CountDownLatch(1);
        CountDownLatch two = new CountDownLatch(1);

        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            foo.first();
            one.countDown();
        });
        Thread t2 = new Thread(() -> {

//            try {
//                t1.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                one.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foo.second();
            two.countDown();
        });
        Thread t3 = new Thread(() -> {
//
//            try {
//                t2.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                two.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foo.third();
        });

        t1.start();
        t2.start();
        t3.start();




    }


    public int clac(int arr[]){


        int minInput = arr[0];
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            minInput = Math.min(minInput,arr[i]);
            max = Math.max(max,arr[i] - minInput);
        }

        return max;

    }
}
