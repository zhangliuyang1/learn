package spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/9/30 下午4:20
 */
@Service
public class ServiceThreeImpl implements ServiceThree {

    @Autowired
    private ServiceOne serviceOne;

    @Override
    public void hello() {
        System.out.println("ServiceThree");
//        serviceOne.hello();
    }
}
