package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/12/14 19:55
 */
public class RmiServer {

    public static void main(String[] args) {
        try {

            UserService userService = new UserServiceImpl();
            LocateRegistry.createRegistry(9999);
            Naming.rebind("rmi://localhost:9999/user",userService);
            System.out.println("start server,port is 9999");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
