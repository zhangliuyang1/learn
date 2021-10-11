package spring.circle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.cyclicdepend.EnterConfig;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/9/30 下午4:21
 */
public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ServiceOne one = applicationContext.getBean(ServiceOne.class);
        one.hello();

    }
}
