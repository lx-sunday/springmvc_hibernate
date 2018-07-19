package org.andy.work.service;

import java.util.List;

import org.andy.support.annotation.Query;
import org.andy.work.entity.AcctUser;


public interface UserService {

	List<AcctUser> findAll();
}
