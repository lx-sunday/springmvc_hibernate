package org.andy.support.support;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Norther Wang
 * @since 2008-3-10 10:12:18
 */
public class HibernateDaoDelegator implements HibernateDao, Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -5850859325220742243L;

    private SessionFactory sessionFactory;

    public Query getNamedQuery(String name) {
	return getSession().getNamedQuery(name);
    }

    public Query createQuery(String hql) {
	return getSession().createQuery(hql);
    }

    public Query createSqlQuery(String sql) {
	return getSession().createSQLQuery(sql);
    }

    public void delete(Object entity) {
	getSession().delete(entity);

    }

    public Object get(Class<?> entityClass, Serializable id, LockOptions lockOptions) {
	return getSession().get(entityClass, id, lockOptions);
    }

    public Object get(Class<?> entityClass, Serializable id) {
	return getSession().get(entityClass, id);
    }

    public Object get(String entityName, Serializable id, LockOptions lockOptions) {
	return getSession().get(entityName, id, lockOptions);
    }

    public Object get(String entityName, Serializable id) {
	return getSession().get(entityName, id);
    }

    public Object load(Class<?> entityClass, Serializable id, LockOptions lockOptions) {
	return getSession().load(entityClass, id, lockOptions);
    }

    public Object load(Class<?> entityClass, Serializable id) {
	return getSession().load(entityClass, id);
    }

    public Object load(String entityName, Serializable id, LockOptions lockOptions) {
	return getSession().load(entityName, id, lockOptions);
    }

    public Object load(String entityName, Serializable id) {
	return getSession().load(entityName, id);
    }

    public Serializable save(Object entity) {
	return getSession().save(entity);
    }

    public Serializable save(String entityName, Object entity) {
	return getSession().save(entityName, entity);
    }

    public void saveOrUpdate(Object entity) {
	getSession().saveOrUpdate(entity);

    }

    public void saveOrUpdate(String entityName, Object entity) {
	getSession().saveOrUpdate(entityName, entity);
    }

    public void update(Object entity) {
	getSession().update(entity);

    }

    public void update(String entityName, Object entity) {
	getSession().update(entityName, entity);

    }

    public void lock(Object entity, LockOptions lockOptions) {
	getSession().buildLockRequest(lockOptions).lock(entity);

    }

    public void lock(String entityName, Object entity, LockOptions lockOptions) {
	getSession().buildLockRequest(lockOptions).lock(entityName, entity);
    }

    public void evict(Object entity) {
	getSession().evict(entity);
    }

    public void merge(Object entity) {
	getSession().merge(entity);
    }

    public void flush() {
	getSession().flush();
    }

    public Session getSession() {
	return getSessionFactory().getCurrentSession();
    }

    public Session buildLockRequest(LockOptions lockOptions) {
	if (lockOptions != null) {
	    getSession().buildLockRequest(lockOptions);
	}
	return getSessionFactory().getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

	@Override
	public int batchSave(Collection<?> entity) {
		int size = entity.size();
		if (size == 0) {
			return 0;
		}
		Iterator<?> iter = entity.iterator();
		Session session = sessionFactory.openSession();
		int i = 0;
		session.beginTransaction();
		try {
			while(iter.hasNext()) {
				i++;
				Object o = iter.next();
				session.save(o);
				if (i % 50 == 0) {
					session.flush();
					session.clear();
				}
			}
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		} finally {
			session.close();
		}
		return i;
	}

}
