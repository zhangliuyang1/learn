package spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/25 下午8:23
 */
@ComponentScan(basePackages = "spring.aop")
@EnableAspectJAutoProxy
public class AppConfig {


}
