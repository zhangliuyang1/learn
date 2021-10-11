package RefType;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/3/23 21:34
 */
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}
