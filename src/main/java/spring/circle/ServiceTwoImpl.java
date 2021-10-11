package spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/9/30 下午4:20
 */
@Service
public class ServiceTwoImpl implements ServiceTwo {

    @Autowired
    private ServiceThree serviceThree;

    @Override
    public void hello() {
        System.out.println("ServiceTwo");
//        serviceThree.hello();
    }


    public void print(){
        System.out.println("print");
    }
}
