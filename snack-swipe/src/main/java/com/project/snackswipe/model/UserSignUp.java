package com.project.snackswipe.model;

import java.util.Base64;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author : lenovo
 * Date : 31-Jan-2025
 * Time : 1:37:20 pm
 * @Id: Marks id as the primary key
 * @Document(collection = "user-deatails"): Maps the class to a MongoDB collection named "user-details".
    //Getters And Setters
    //Constructors
*/

@Document(collection= "user-details")
public class UserSignUp 
{
    @Id
    private String id;

    private String userType;

    private String courseOrDept;

    private String other;

    private String email;

    private String password;

    private String name;

    private String prnOrEmployeeId;

	public UserSignUp() {
		super();
	}

	public UserSignUp(String userType, String courseOrDept, String other, String email, String password, String name,
			String prnOrEmployeeId) {
		super();
		this.userType = userType;
		this.courseOrDept = courseOrDept;
		this.other = other;
		this.email = email;
		this.password = password;
		this.name = name;
		this.prnOrEmployeeId = prnOrEmployeeId;
	}

	public UserSignUp(String id, String userType, String courseOrDept, String other, String email, String password,
			String name, String prnOrEmployeeId) {
		super();
		this.id = id;
		this.userType = userType;
		this.courseOrDept = courseOrDept;
		this.other = other;
		this.email = email;
		this.password = password;
		this.name = name;
		this.prnOrEmployeeId = prnOrEmployeeId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

	/**
	 * @return the courseOrDept
	 */
	public String getCourseOrDept() {
		return courseOrDept;
	}

	/**
	 * @param courseOrDept the courseOrDept to set
	 */
	public void setCourseOrDept(String courseOrDept) {
		this.courseOrDept = courseOrDept;
	}

	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
