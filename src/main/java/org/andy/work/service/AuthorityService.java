package org.andy.work.service;

import java.util.List;

import org.andy.work.entity.AcctAuthority;


public interface AuthorityService {
	AcctAuthority load(String id);

	AcctAuthority get(String id);

	List<AcctAuthority> findAll();

	void persist(AcctAuthority entity);

	String save(AcctAuthority entity);

	void saveOrUpdate(AcctAuthority entity);

	void delete(String id);

	void flush();
	
}
