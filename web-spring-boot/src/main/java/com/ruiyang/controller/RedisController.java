package com.ruiyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruiyang.dao.RedisDao;

@RestController
public class RedisController {

	@Autowired
	private RedisDao redisDao;
	
	@RequestMapping("/testRedis")
	public String testRedis(){
		System.out.println("-------------------");
		redisDao.setKey("name", "James");
		redisDao.setKey("age", "31");
		System.out.println(redisDao.getValue("name"));
        System.out.println(redisDao.getValue("age"));
        return redisDao.getValue("name")+"今年"+redisDao.getValue("age")+"岁了！";
	}
}
