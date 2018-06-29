package com.ruiyang.controller;
 
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruiyang.domain.NewUser;
import com.ruiyang.domain.User;
import com.ruiyang.service.IUserService;
import com.ruiyang.utils.AES256Util;
 
@RestController
public class StuController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="查找用户", notes="根据User名称查找用户")
    @ApiImplicitParam(name = "name", paramType = "query",  value = "用户姓名", required = true, dataType = "String")
	public String getUser(@ApiParam("name") String name) {
//		User stu = userService.getUserById(1);
		User stu = userService.getUserByName(name);
		
		return stu.getAge()+"";
	}
	
	@RequestMapping(value="/encrypts", method=RequestMethod.GET)
	@ApiOperation(value="查找用户", notes="查找所有已加密的用户")
	@ResponseBody
	public Map<String, Object> queryEncryptUsrs(){
		List<NewUser> list = userService.queryEncryptedUser();
		for(NewUser u : list){
			if(StringUtils.isNotEmpty(u.getUserName())){
				u.setUserName(AES256Util.decryptStr(u.getUserName()));
			}
			if(StringUtils.isNoneEmpty(u.getUserEmail())){
				u.setUserEmail(AES256Util.decryptStr(u.getUserEmail()));
			}
			if(StringUtils.isNoneEmpty(u.getUserPhone())){
				u.setUserPhone(AES256Util.decryptStr(u.getUserPhone()));
			}
			if(StringUtils.isNoneEmpty(u.getUserImage())){
				u.setUserImage(AES256Util.decryptStr(u.getUserImage()));
			}
		}
		userService.updateBatchUsers(list);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Map<String, Object> ret = new HashMap();
		ret.put("data", list);
		
		return ret;
	}
}
