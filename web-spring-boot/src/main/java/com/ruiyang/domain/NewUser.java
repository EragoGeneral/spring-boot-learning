package com.ruiyang.domain;

public class NewUser {

	private Integer userId;
	
	private String userName;
	
	private String userEmail;
	
	private String userPhone;
	
	private String userImage;
	
	private Integer isEncrypt;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Integer getIsEncrypt() {
		return isEncrypt;
	}

	public void setIsEncrypt(Integer isEncrypt) {
		this.isEncrypt = isEncrypt;
	}
}
