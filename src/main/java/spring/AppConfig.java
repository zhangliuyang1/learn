package spring;

import com.google.errorprone.annotations.CompatibleWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/4/2 21:02
 */
@Configuration
@ComponentScan(basePackages = "spring")
public class AppConfig {




    @Bean
    public A a(){
        return new A();
    }

    @Bean
    public B b(){
        return new B();
    }

    @Bean
    public C c(){
        return new C();
    }


    @Bean
    public D d(){
        return new D();
    }
}
