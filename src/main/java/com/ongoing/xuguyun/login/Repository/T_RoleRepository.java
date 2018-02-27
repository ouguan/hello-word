package com.ongoing.xuguyun.login.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ongoing.xuguyun.login.DAO.T_Role;

public interface T_RoleRepository extends JpaRepository<T_Role, Integer> {

	@Query("select role from T_Role role where role.roleName=?1")
	public List<T_Role> findOne(String roleName);
	
}
