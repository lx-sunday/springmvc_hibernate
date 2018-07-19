package org.andy.support;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.andy.support.annotation.Query;
import org.andy.support.processor.QueryMethodProcessor;
import org.andy.support.support.HibernateDao;

public class DynamicDaoInvocationHandler implements InvocationHandler,Serializable {
	
	private static final long serialVersionUID = -1497044879478450970L;
	
    private HibernateDao hibernateDao;
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] parameters) throws Throwable {
		// TODO Auto-generated method stub
		Annotation[] annotations = method.getAnnotations();
		for(Annotation each :annotations){
			@SuppressWarnings("rawtypes")
		    DaoMethodProcessor daoMethodProcessor = null;
		    Class<? extends Annotation> annotationClass = each.annotationType();
		    if(annotationClass.equals(Query.class)){
		    	daoMethodProcessor=new QueryMethodProcessor();
		    }
		    
		    if(daoMethodProcessor!=null){
		    	daoMethodProcessor.setAnnotation(each);
				daoMethodProcessor.setParameters(parameters);
				daoMethodProcessor.setParameterAnnotations(method.getParameterAnnotations());
				daoMethodProcessor.setHibernateDao(hibernateDao);
				daoMethodProcessor.setMethod(method);
				return daoMethodProcessor.process();
		    }
		    
		}
		
		throw new IllegalStateException("the method of invocation is not a valid dao method");
	}


	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
}
