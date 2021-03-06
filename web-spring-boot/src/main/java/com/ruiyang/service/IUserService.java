package com.ruiyang.service;

import java.util.List;

import com.ruiyang.domain.NewUser;
import com.ruiyang.domain.User;

public interface IUserService {

	public User getUserById(int id);
	
	public User getUserByName(String name);
	
	public List<NewUser> queryEncryptedUser();
	
	public boolean updateBatchUsers(List<NewUser> users);
}
