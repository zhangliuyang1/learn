package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/12/14 19:50
 */
public interface UserService extends Remote {

    User findUser(long id) throws RemoteException;

}
