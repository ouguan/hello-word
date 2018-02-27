package com.ongoing.xuguyun.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ongoing.xuguyun.login.DAO.T_Role;
import com.ongoing.xuguyun.login.Repository.T_RoleRepository;

@RestController
public class T_RoleController {

	@Autowired
	private T_RoleRepository roleRepository;

	@GetMapping(value = "/getRoleByType")
	public List<T_Role> roleInfo() {
		return roleRepository.findAll();
	}

	@GetMapping(value = "/getRoleByName")
	public List<T_Role> roleInfo(@RequestParam("roleName") String roleName) {
		return roleRepository.findOne(roleName);
	}

	@PostMapping(value = "/addRole")
	public T_Role roleAdd(@RequestParam("roleType") Integer roleType, @RequestParam("roleName") String roleName,
			@RequestParam("roleURL") String roleURL, @RequestParam("roleDesc") String roleDesc) {
		T_Role role = new T_Role();
		role.setRoleType(roleType);
		role.setRoleName(roleName);
		role.setRoleURL(roleURL);
		role.setRoleDesc(roleDesc);

		return roleRepository.save(role);
	}
}
