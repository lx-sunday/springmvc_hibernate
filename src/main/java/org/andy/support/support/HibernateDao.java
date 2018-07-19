package org.andy.support.support;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.LockOptions;
import org.hibernate.Query;

/**
 * 
 * @author Norther Wang
 * @since 2008-3-11 08:47:38
 */
public interface HibernateDao {

    Query getNamedQuery(String name);

    Query createQuery(String hql);

    Query createSqlQuery(String sql);

    void delete(Object entity);

    Object get(Class<?> entityClass, Serializable id);

    Object get(Class<?> entityClass, Serializable id, LockOptions lockOptions);

    Object get(String entityName, Serializable id);

    Object get(String entityName, Serializable id, LockOptions lockOptions);

    Object load(Class<?> entityClass, Serializable id);

    Object load(String entityName, Serializable id);

    Object load(Class<?> entityClass, Serializable id, LockOptions lockOptions);

    Object load(String entityName, Serializable id, LockOptions lockOptions);

    Serializable save(Object entity);

    Serializable save(String entityName, Object entity);

    void saveOrUpdate(Object entity);

    void saveOrUpdate(String entityName, Object entity);

    void update(Object entity);

    void update(String entityName, Object entity);

    void lock(Object entity, LockOptions lockOptions);

    void lock(String entityName, Object entity, LockOptions lockOptions);

    void evict(Object entity);

    void merge(Object entity);

    void flush();

    int batchSave(Collection<?> entity);
}
