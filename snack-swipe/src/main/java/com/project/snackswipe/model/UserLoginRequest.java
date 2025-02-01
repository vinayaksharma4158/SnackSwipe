package com.project.snackswipe.model;

/**
 * Author : lenovo
 * Date : 31-Jan-2025
 * Time : 9:35:35 pm
*/

public class UserLoginRequest 
{
	private String prnOrEmployeeId;
	private String password;
	private String userType;
	
	public UserLoginRequest()
	{
		
	}
	/**
	 * @return the prnOrEmployeeId
	 */
	public String getPrnOrEmployeeId() {
		return prnOrEmployeeId;
	}
	/**
	 * @param prnOrEmployeeId the prnOrEmployeeId to set
	 */
	public void setPrnOrEmployeeId(String prnOrEmployeeId) {
		this.prnOrEmployeeId = prnOrEmployeeId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	

}
