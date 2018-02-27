package com.ongoing.xuguyun.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ongoing.xuguyun.login.DAO.T_User;
import com.ongoing.xuguyun.login.Repository.T_UserRepository;

@RestController
public class T_UserController {
	@Autowired
	private T_UserRepository userRepository;

	@GetMapping(value = "/getUserByID")
	public List<T_User> roleInfo() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/getUserByName")
	public List<T_User> roleInfo(String userName) {
		
		return userRepository.findOne(userName);
	}

	@PostMapping(value = "/addUser")
	public T_User userAdd(@RequestParam("roleType") Integer roleType, @RequestParam("userID") Integer userID,
			@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd,
			@RequestParam("userEmail") String userEmail, @RequestParam("userPhone") String userPhone,
			@RequestParam("userMobel") String userMobel, @RequestParam("userDesc") String userDesc) {
		T_User user = new T_User();
		user.setRoleType(roleType);
		user.setUserID(userID);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setUserEmail(userEmail);
		user.setUserPhone(userPhone);
		user.setUserMobel(userMobel);
		user.setUserDesc(userDesc);

		return userRepository.save(user);
	}

}
