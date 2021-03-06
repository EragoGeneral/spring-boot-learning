package com.ruiyang.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ApiOperation(value="查找用户", notes="根据User名称查找用户")
	public String index(){
		return "hello";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ApiOperation(value="查找用户", notes="根据User名称查找用户")
	public String login(){
		return "login";
	}
}
