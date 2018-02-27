package com.ongoing.xuguyun.login.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Entity
@Component
@ConfigurationProperties(prefix = "T_Role")
public class T_Role {

	@Id
	@Column(name = "roleType", nullable = false)
	private Integer roleType;

	@Column(name = "roleName", nullable = false, unique = true)
	private String roleName;

	private String roleURL;

	private String roleDesc;

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleURL() {
		return roleURL;
	}

	public void setRoleURL(String roleURL) {
		this.roleURL = roleURL;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
