package RefType;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/23 21:37
 */
public class T03_WeakReference {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();

        tl.set(new M());
        tl.remove();
    }
}
