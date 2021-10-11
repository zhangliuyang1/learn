package spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.cyclicdepend.ServiceA;
import spring.ioc.cyclicdepend.ServiceB;
import spring.ioc.cyclicdepend.ServiceC;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 10:42
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("application.xml");

//        BeanFactory
        ServiceA serviceA = application.getBean("serviceA", ServiceA.class);
////        ServiceB serviceB = application.getBean("serviceB", ServiceB.class);
////        ServiceC serviceC = application.getBean("serviceC", ServiceC.class);




    }
}
