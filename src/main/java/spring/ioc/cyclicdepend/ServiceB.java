package spring.ioc.cyclicdepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 10:51
 */
@Service
public class ServiceB {

    @Autowired
    private ServiceC serviceC;

    public ServiceB() {
        System.out.println("serviceB init");

    }

    public ServiceC getServiceC() {
        return serviceC;
    }

    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
    }
}
