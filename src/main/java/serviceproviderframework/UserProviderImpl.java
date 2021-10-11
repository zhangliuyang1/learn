package serviceproviderframework;

public class UserProviderImpl implements IUserProvider {
    public IUserService getUserService() {
        return new UserServiceImpl();
    }

    static {
        ServiceManager.registerProvider("loginRegister",new UserProviderImpl());
    }
}
