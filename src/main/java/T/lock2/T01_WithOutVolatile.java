package T.lock2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/17 10:26
 */
public class T01_WithOutVolatile {

    volatile List<String> list = new ArrayList<>();

    void add(String str) {
        list.add(str);
    }

    int getSize() {
        return list.size();
    }


    public static void main(String[] args) {
        T01_WithOutVolatile o = new T01_WithOutVolatile();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                o.add(i + "");
                System.out.println("add " + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {


            while (true){

//                System.out.println(o.getSize());
                if (o.getSize() == 5){
                    System.out.println("T2 stop");
                    break;
                }
            }
        }).start();

    }
}
