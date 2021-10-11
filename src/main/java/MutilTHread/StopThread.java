package MutilTHread;

import java.util.concurrent.TimeUnit;

public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws Exception{
//        System.out.println(stopRequested);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested){
                    i++;
                    System.out.println(i);
                    System.out.println(stopRequested);
                }
                System.out.println("after while:" + stopRequested);
            }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(5);

        stopRequested = true;
        System.out.println("main:" + stopRequested);
    }
}
