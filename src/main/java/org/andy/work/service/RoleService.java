package org.andy.work.service;

import java.util.List;

import org.andy.work.entity.AcctRole;


public interface RoleService {
	AcctRole load(String id);

	AcctRole get(String id);

	List<AcctRole> findAll();

	void persist(AcctRole entity);

	String save(AcctRole entity);

	void saveOrUpdate(AcctRole entity);

	void delete(String id);

	void flush();
}
