package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/25 下午8:25
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloService service = applicationContext.getBean(HelloService.class);
        service.hello("sss");

    }
}
