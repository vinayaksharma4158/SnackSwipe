package com.project.snackswipe.model;

import org.apache.commons.codec.binary.Base64;

public class ResetPasswordRequest {
	private String userType;
	private String prnOrEmployeeId;
	private String email;
	private String newPassword;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPrnOrEmployeeId() {
		return prnOrEmployeeId;
	}
	public void setPrnOrEmployeeId(String prnOrEmployeeId) {
		this.prnOrEmployeeId = prnOrEmployeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewPassword() {
		return new String(Base64.decodeBase64(newPassword));
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = Base64.encodeBase64String(newPassword.getBytes());
	}
	
	
	
	
}
