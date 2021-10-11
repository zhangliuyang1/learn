package spring.ioc.cyclicdepend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/9/1 10:51
 */
@Service
public class ServiceA {

    @Autowired
    private ServiceB serviceB;


    public ServiceA() {
        System.out.println("serviceA init");
    }

    public ServiceB getServiceB() {
        return serviceB;
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
