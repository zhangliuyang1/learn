package spring.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/25 下午8:23
 */
@ComponentScan(basePackages = "spring.aop")
@EnableAspectJAutoProxy
@Configuration
public class AppConfig {

//    @Bean(name = "regexpMethodPointcutAdvisor")
//    public RegexpMethodPointcutAdvisor regexpMethodPointcutAdvisor(AopAdvice aopAdvice){
//        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
//        advisor.setAdvice(aopAdvice);
//        advisor.setPattern("spring.aop");
//        return advisor;
//    }
//
//    @Bean
//    public ProxyFactoryBean proxyFactoryBean(){
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setTargetClass(HelloService.class);
////        proxyFactoryBean.setInterceptorNames("regexpMethodPointcutAdvisor");
//        return proxyFactoryBean;
//    }

}
