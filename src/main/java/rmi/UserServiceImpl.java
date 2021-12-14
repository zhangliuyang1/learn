package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/12/14 19:52
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {


    protected UserServiceImpl() throws RemoteException {
    }

    @Override
    public User findUser(long id) throws RemoteException {
        if (id == 1){
            System.out.println("userService.findUser()");
            return new User(1,"zzz",22);
        }
       throw new RemoteException("查不到该id");
    }
}
