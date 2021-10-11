package singleton;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/16 14:28
 */
public class St02 {

    private static St02 INSTANCE = null;
    private St02(){

    }

    public static synchronized St02 getInstance(){
        if (INSTANCE == null){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new St02();
        }
        return INSTANCE;
    }
}
