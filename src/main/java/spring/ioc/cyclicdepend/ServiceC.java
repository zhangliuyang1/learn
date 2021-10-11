package spring.ioc.cyclicdepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 10:51
 */
@Service
public class ServiceC {

    @Autowired
    private ServiceA serviceA;

    public ServiceC() {
        System.out.println("serviceC init");
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
