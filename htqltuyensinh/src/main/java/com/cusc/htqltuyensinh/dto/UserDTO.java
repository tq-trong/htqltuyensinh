package com.cusc.htqltuyensinh.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UserDTO extends BaseDTO<UserDTO>{
	private String name;
	private Date birthday;
	private String job;
	private String province;
	private String school;
	private String email;
	private String phone;
	private String fatherPhone;
	private String motherPhone;
	private String zalo;
	private String facebook;
	private String gatherDescription;
	private boolean gender;
	private boolean status;
	private List<String> favoriteSubjects;
	private String descriptionSubject;
	
	public String getDescriptionSubject() {
		return descriptionSubject;
	}
	public void setDescriptionSubject(String descriptionSubject) {
		this.descriptionSubject = descriptionSubject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFatherPhone() {
		return fatherPhone;
	}
	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}
	public String getMotherPhone() {
		return motherPhone;
	}
	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}
	public String getZalo() {
		return zalo;
	}
	public void setZalo(String zalo) {
		this.zalo = zalo;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getGatherDescription() {
		return gatherDescription;
	}
	public void setGatherDescription(String gatherDescription) {
		this.gatherDescription = gatherDescription;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<String> getFavoriteSubjects() {
		return favoriteSubjects;
	}
	public void setFavoriteSubjects(List<String> favoriteSubjects) {
		this.favoriteSubjects = favoriteSubjects;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	
}
