package T.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/24 20:11
 */
public class T01_SynchronusQueue {

    public static void main(String[] args) {

        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                while (true){
                    System.out.println(queue.take());

                }
            }catch (Exception e){

            }
        }).start();

        try {
            queue.put("a");
            queue.put("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue.size());

    }
}
