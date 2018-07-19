package org.andy.work.controller;

import java.util.List;

import org.andy.work.entity.AcctUser;
import org.andy.work.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
  * 用户controller层
  * @ClassName: UserController
  * @Description: TODO
  * @author lx
  * @date 2018年7月18日 下午9:03:15
  *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfos")
	public @ResponseBody List<AcctUser> showUserInfos(){
		LOGGER.info("查询用户全部用户");
		List<AcctUser> userInfos = userService.findAll();
		return userInfos;
	}
}
