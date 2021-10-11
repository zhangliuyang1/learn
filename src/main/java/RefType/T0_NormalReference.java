package RefType;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/23 21:37
 */
public class T0_NormalReference {

    public static void main(String[] args) throws Exception {
        M m = new M();

        m = null;
        System.gc();

        System.in.read();
    }
}
