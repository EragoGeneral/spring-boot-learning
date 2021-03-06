package com.ruiyang.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ruiyang.domain.User;

@Mapper
public interface StuMapper {
	
	@Select("select * from t_user where username = #{name}")
	@Results(id="userMap", value = {
		@Result(column = "id", property = "id", javaType = Integer.class),
		@Result(column = "username", property = "username", javaType = String.class)
	})
	public User queryByName(@Param("name")String name);
}
