package spring.aop;

import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/10/25 下午8:26
 */
@Service
public class HelloService {

    public String hello(String v){
        System.out.println("HelloService.hello : " + v);
        return v;
    }
}
