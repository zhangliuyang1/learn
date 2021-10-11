package singleton;

/**
 * DCL Double Check Lock
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 14:29
 */
public class St03 {

    public int a = 100;

    private static St03 INSTANCE = null;


    private St03(){

    }

    public static St03 getInstance(){
        if (INSTANCE == null){
            synchronized (St03.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new St03();
                }
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                St03 instance = St03.getInstance();
                System.out.println(instance.hashCode());
                System.out.println(instance.a);
            }).start();
        }
    }

}


