package org.andy.support;

import java.io.Serializable;
import java.lang.reflect.Proxy;

import org.andy.support.support.HibernateDaoDelegator;
import org.hibernate.SessionFactory;

public class DynamicDaoFactory implements Serializable {

	    private static final long serialVersionUID = -1432774123882533729L;

	    /**
	     * 
	      * 通过specified invocation handler生成一个代理实例
	      * @Description: TODO
	      * @param clazz  代理实例实现的接口
	      * @param sessionFactory
	      * @return T 返回实现dao接口的代理实例
	      * @exception:
	      * @throws
	      * @author: lx
	      * @time:2018年7月19日 下午1:37:00
	     */
	    @SuppressWarnings("unchecked")
	    public static <T> T create(Class<T> clazz, SessionFactory sessionFactory) {
		HibernateDaoDelegator hibernateDaoDelegator = new HibernateDaoDelegator();
		hibernateDaoDelegator.setSessionFactory(sessionFactory);

		DynamicDaoInvocationHandler dynamicDaoInvocationHandler = new DynamicDaoInvocationHandler();
		dynamicDaoInvocationHandler.setHibernateDao(hibernateDaoDelegator);
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, dynamicDaoInvocationHandler);
	    }
}
