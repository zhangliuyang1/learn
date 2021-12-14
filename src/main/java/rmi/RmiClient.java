package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/12/14 19:58
 */
public class RmiClient {
    public static void main(String[] args) {
        try {
            UserService userService = (UserService) Naming.lookup("rmi://localhost:9999/user");
            User user = userService.findUser(1);
            System.out.println(user);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}