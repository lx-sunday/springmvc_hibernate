package org.andy.work.dao;

import java.util.List;

import org.andy.support.annotation.Query;
import org.andy.work.entity.AcctUser;


public interface UserDao{

	@Query("from AcctUser bean")
	List<AcctUser> findAll();

}
