package serviceproviderframework;

public class UserServiceImpl implements IUserService {

    public void register() {
        System.out.println("注册");
    }

    public void login() {
        System.out.println("登录");
    }

    public void loginOut() {
        System.out.println("退出");
    }
}
