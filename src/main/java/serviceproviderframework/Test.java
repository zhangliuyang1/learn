package serviceproviderframework;

public class Test {

    public static void main(String[] args) {

        try {
            Class.forName("serviceproviderframework.UserProviderImpl");

            IUserService userService = ServiceManager.getUserService("loginRegister");

            userService.register();
            userService.login();
            userService.loginOut();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
