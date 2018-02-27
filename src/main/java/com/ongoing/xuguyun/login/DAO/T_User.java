package com.ongoing.xuguyun.login.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Entity
@Component
@ConfigurationProperties(prefix = "T_User")
public class T_User {
	
	@Column(name = "roleType", nullable = false)
	private Integer roleType;

	@Id
	@Column(name = "userID", nullable = false)
	private Integer userID;
	
	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "userPwd", nullable = false)
	private String userPwd;

	private String userEmail;

	private String userPhone;

	private String userMobel;

	private String userDesc;

	public T_User() {
		
	}
	
	public T_User(int roleType, int userID, String userName, String userPwd) {
		// TODO Auto-generated constructor stub
		this.roleType = roleType;
		this.userID = userID;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMobel() {
		return userMobel;
	}

	public void setUserMobel(String userMobel) {
		this.userMobel = userMobel;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

}
