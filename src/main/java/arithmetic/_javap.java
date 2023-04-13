package arithmetic;

/**
 * @author: zhangliuyang01
 * @date: 2023/3/31 15:07
 */
public class _javap {
    private static int count;

    public static void increase(){
        count++;
    }


    public static synchronized void increases(){
        count++;
    }

    public void incr(){
        synchronized (this){
            count++;
        }
    }

    public static void main(String[] args) {
        increase();
        System.out.println(count);
    }
}
