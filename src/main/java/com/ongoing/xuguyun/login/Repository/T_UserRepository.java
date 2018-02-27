package com.ongoing.xuguyun.login.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ongoing.xuguyun.login.DAO.T_User;

public interface T_UserRepository extends JpaRepository<T_User, Integer> {

	@Query("select user from T_User user where user.userName=?1")
	public List<T_User> findOne(String userName);

}
