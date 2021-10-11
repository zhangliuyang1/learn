package RefType;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/23 21:37
 */
public class T02_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 2]);
        System.out.println(m.get());

        System.gc();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());


        byte[] b = new byte[1024 * 1024 * 12];

        System.out.println(m.get());
    }
}
