package org.andy.work.service.impl;

import java.util.List;

import org.andy.support.annotation.InjectDao;
import org.andy.work.dao.UserDao;
import org.andy.work.entity.AcctUser;
import org.andy.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@InjectDao
	private UserDao userDao;

	@Override
	public List<AcctUser> findAll() {
		return userDao.findAll();
	}

}
