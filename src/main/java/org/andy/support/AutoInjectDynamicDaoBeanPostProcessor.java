package org.andy.support;

import java.io.Serializable;
import java.lang.reflect.Field;

import org.andy.support.annotation.InjectDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
  * 实现BeanPostProcessor(在bean被初始化之前或者之后添加其他业务逻辑)
  * @ClassName: AutoInjectDynamicDaoBeanPostProcessor
  * @Description: TODO
  * @author lx
  * @date 2018年7月19日 上午10:11:00
  *
 */
public class AutoInjectDynamicDaoBeanPostProcessor implements BeanPostProcessor,Serializable {

	 private static final long serialVersionUID = -7462250644155872642L;

	    private static final Logger LOG = Logger.getLogger(AutoInjectDynamicDaoBeanPostProcessor.class);

	    @Autowired
	    private SessionFactory sessionFactory;

	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		Field[] fields = bean.getClass().getDeclaredFields();
		if (fields != null) {
		    for (Field field : fields) {
			InjectDao annotation = field.getAnnotation(InjectDao.class);
			if (annotation == null) {
			    continue;
			}
			Object dao = DynamicDaoFactory.create(field.getType(), sessionFactory);
			field.setAccessible(true);
			try {
			    field.set(bean, dao);
			} catch (IllegalArgumentException e) {
			    throw new BeanInitializationException(e.getMessage());
			} catch (IllegalAccessException e) {
			    throw new BeanInitializationException(e.getMessage());
			}
		    }
		}
		return bean;
	}


}
