package com.cusc.htqltuyensinh.api.output;

import java.util.Date;

import com.cusc.htqltuyensinh.dto.AdminDTO;

public class AdminOutput extends AbstractOutput<AdminDTO>{
	private String code;
	private String name;
	private Date birthday;
	private String username;
	private String password;
	private boolean gender;
	private String phone;
	private String address;
	private String email;
	private boolean role;
	private boolean status;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public AdminOutput(String code, String name, Date birthday, String username, String password, boolean gender,
			String phone, String address, String email, boolean role, boolean status) {
		this.code = code;
		this.name = name;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.role = role;
		this.status = status;
	}
	public AdminOutput() {
		
	}
	
	
	
	
}
