package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.controller.DemoController;
import spring.daoddd.DemoDao;
import spring.service.DemoService;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/4/2 21:17
 */
public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();

        System.out.println(context.getBean(A.class));
        System.out.println(context.getBean(B.class));
        System.out.println(context.getBean(C.class));
        System.out.println(context.getBean(D.class));

        System.out.println(context.getBean(DemoController.class));
        System.out.println(context.getBean(DemoService.class));
        System.out.println(context.getBean(DemoDao.class));
    }
}
