package com.ongoing.xuguyun.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ongoing.xuguyun.login.DAO.T_User;
import com.ongoing.xuguyun.login.Service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 普通访问用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/default")
	public String defLogin() {
		// 首页
		return "Hello " + getLogin().getUserName();
	}

	@RequestMapping(value = "/doLogin")
	public String specLogin(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd) {
		return "Hello " + getLogin(userName, userPwd).getUserName();
	}

	public T_User getLogin() {
		return loginService.getUser().get(0);
	}

	//@GetMapping(value = "/findUser")
//	public V_LoginUser getLogin(@RequestParam("userName") String userName) {
//		return loginService.findUser(userName).get(0);
//	}

	@GetMapping(value = "/login")
	public T_User getLogin(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd) {
		return loginService.getUser(userName).get(0);
	}
}
