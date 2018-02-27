package com.ongoing.xuguyun.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ongoing.xuguyun.login.DAO.V_LoginUser;

public interface LoginRepository extends JpaRepository<V_LoginUser, String> {

	//@Query("SELECT U.USER_NAME,U.USER_PWD,U.USER_EMAIL,R.ROLE_NAME,R.ROLEURL FROM T_USER U JOIN T_ROLE R ON U.ROLE_TYPE=R.ROLE_TYPE WHERE U.USER_NAME=?1")
	//public List<V_LoginUser> findUser(String userName);
}
