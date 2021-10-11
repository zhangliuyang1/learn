package singleton;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 14:27
 */
public class St01 {

    private static St01 INSTANCE = null;
    private St01(){

    }

    public static St01 getInstance(){
        if (INSTANCE == null){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new St01();
        }
        return INSTANCE;
    }
}
