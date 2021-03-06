package com.ruiyang.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ruiyang.dao.IUserDao;
import com.ruiyang.domain.User;

//@Repository
public class UserDaoImpl implements IUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUserById(int id) {
		
		List<User> list = jdbcTemplate.query("select * from t_user where id = ?", new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
		
		if(list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}
}
