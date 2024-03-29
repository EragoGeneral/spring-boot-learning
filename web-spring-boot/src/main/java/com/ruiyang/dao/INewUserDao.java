package com.ruiyang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruiyang.domain.NewUser;

public interface INewUserDao {
	
	public List<NewUser> queryEncryptedUser();
	
	public boolean updateBatchUsers(@Param("users")List<NewUser> users);
}
