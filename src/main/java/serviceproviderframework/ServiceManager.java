package serviceproviderframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceManager {

    private ServiceManager() {

    }

    private static final Map<String, IUserProvider> providers = new ConcurrentHashMap<>();

    public static void registerProvider(String name, IUserProvider userProvider) {
        providers.put(name, userProvider);
    }

    public static IUserService getUserService(String name) {

        IUserProvider provider = providers.get(name);

        if (provider == null){
            throw new IllegalArgumentException("no provider registed with name = " + name);
        }

        return provider.getUserService();

    }
}
