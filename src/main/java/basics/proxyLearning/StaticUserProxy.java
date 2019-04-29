package basics.proxyLearning;

import org.junit.Test;

public class StaticUserProxy {
    @Test
    public void testStaticProxy() {
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}