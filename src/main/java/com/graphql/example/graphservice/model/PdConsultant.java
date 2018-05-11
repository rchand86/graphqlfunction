package com.graphql.example.graphservice.model;

import java.sql.Date;

public class PdConsultant implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
	private String surname;
	private String middleName;
	private String jobTitle;
	private String title;
	private String mobile;
	private String businessPhone;
	private String privatePhone;
	private String email;
	private int employmentNumber;
	private String loginName;
	private Integer achievementType;
	private Integer bonusPoints;
	
	
	
	public PdConsultant(Long id, String firstName, String surname, String middleName, String jobTitle, String title,
			String mobile, String businessPhone, String privatePhone, String email, int employmentNumber,
			String loginName, Integer achievementType, Integer bonusPoints) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.middleName = middleName;
		this.jobTitle = jobTitle;
		this.title = title;
		this.mobile = mobile;
		this.businessPhone = businessPhone;
		this.privatePhone = privatePhone;
		this.email = email;
		this.employmentNumber = employmentNumber;
		this.loginName = loginName;
		this.achievementType = achievementType;
		this.bonusPoints = bonusPoints;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBusinessPhone() {
		return businessPhone;
	}
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	public String getPrivatePhone() {
		return privatePhone;
	}
	public void setPrivatePhone(String privatePhone) {
		this.privatePhone = privatePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmploymentNumber() {
		return employmentNumber;
	}
	public void setEmploymentNumber(int employmentNumber) {
		this.employmentNumber = employmentNumber;
	}
	
	public Integer getAchievementType() {
		return achievementType;
	}
	public void setAchievementType(Integer achievementType) {
		this.achievementType = achievementType;
	}
	public Integer getBonusPoints() {
		return bonusPoints;
	}
	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}