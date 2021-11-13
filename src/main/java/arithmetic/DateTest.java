package arithmetic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/11/11 下午7:12
 */
public class DateTest {

    public static void main(String[] args) {
        Date date = new Date(1636623938083L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(format.format(date));
    }
}
