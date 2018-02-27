package com.ongoing.xuguyun.login.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ongoing.xuguyun.login.DAO.T_User;
import com.ongoing.xuguyun.login.DAO.V_LoginUser;
import com.ongoing.xuguyun.login.Repository.LoginRepository;
import com.ongoing.xuguyun.login.Repository.T_UserRepository;

@Service
public class LoginService {

	@Autowired
	private T_UserRepository userRepository;
	
	@Autowired
	//private LoginRepository loginRepository;
	
	public List<T_User> getUser() {
		return userRepository.findOne("guest");
	}
	
	public List<T_User> getUser(String userName) {
		return userRepository.findOne(userName);
	}
	
//	public List<V_LoginUser> findUser(String userName) {
//		return loginRepository.findUser(userName);
//	}
}
