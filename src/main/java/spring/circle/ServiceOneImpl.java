package spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/9/30 下午4:19
 */
@Service
public class ServiceOneImpl implements ServiceOne {

    @Autowired
    private ServiceTwoImpl serviceTwoImpl;

    @Override
    public void hello() {
        System.out.println("ServiceOne");
        serviceTwoImpl.hello();

        serviceTwoImpl.print();
    }
}
