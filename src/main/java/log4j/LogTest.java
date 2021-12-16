package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @Author: zhangliuyang01
 * @Date: 2021/12/13 下午2:38
 */
public class LogTest {

    private static final Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        String str = "world";
        String lu = "${log4j:configParentLocation}";
        logger.info("hello,{}",lu);
    }
}
