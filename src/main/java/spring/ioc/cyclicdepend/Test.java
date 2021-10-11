package spring.ioc.cyclicdepend;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 17:24
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnterConfig.class);
//        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        Collection<ApplicationListener<?>> applicationListeners = applicationContext.getApplicationListeners();

        System.out.println(applicationContext.getBean("serviceA"));
    }
}
