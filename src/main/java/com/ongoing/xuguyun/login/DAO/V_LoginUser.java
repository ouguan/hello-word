package com.ongoing.xuguyun.login.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Entity
@Component
@ConfigurationProperties(prefix = "V_LoginUser")
public class V_LoginUser {

	@Column(name = "roleName", nullable = false)
	private String roleName;

	@Column(name = "roleURL", nullable = false)
	private String roleURL;

	@Id
	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "userPwd", nullable = false)
	private String userPwd;

	@Column(name = "userEmail", nullable = false)
	private String userEmail;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
