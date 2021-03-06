package com.ruiyang.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruiyang.dao.INewUserDao;
import com.ruiyang.dao.IUserDao;
import com.ruiyang.dao.StuMapper;
import com.ruiyang.domain.NewUser;
import com.ruiyang.domain.User;
import com.ruiyang.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, Serializable {

	private static final long serialVersionUID = -492993133703568489L;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private StuMapper stuMapper;
	
	@Autowired
	private INewUserDao newUserDao;
	
	@Override
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		
		return stuMapper.queryByName(name);
	}

	@Override
	public List<NewUser> queryEncryptedUser() {
		
		return newUserDao.queryEncryptedUser();
	}

	@Override
	public boolean updateBatchUsers(List<NewUser> users) {
		
		return newUserDao.updateBatchUsers(users);
	}
}
