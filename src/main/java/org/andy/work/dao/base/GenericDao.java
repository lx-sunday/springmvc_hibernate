package org.andy.work.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * dao通用接口
  * 
  * @ClassName: GenericDao
  * @Description: TODO
  * @author lx
  * @date 2018年7月18日 下午9:05:46
  *
  * @param <T>
  * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {
	
	T load(PK id);
	
	T get(PK id);
	
	List<T> findAll();
	
	void persist(T entity);
	
	PK save(T entity);
	
	void saveOrUpdate(T entity);
	
	void delete(PK id);
	
	void flush();
}
