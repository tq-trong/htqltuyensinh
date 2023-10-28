package com.cusc.htqltuyensinh.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "admins")
public class AdminEntity extends BaseEntity{
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "gender")
	private boolean gender;
	
	@Pattern(regexp = "^[0-9]{10,11}$", message = "Số điện thoại không hợp lệ")
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Email(message = "Email không hợp lệ")
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private boolean role;
	
	@Column(name = "status")
	private boolean status;

	@OneToMany(mappedBy = "admin")
    private List<LoginTimeEntity> loginTime = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin")
    private List<NoteEntity> notes = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin")
    private List<ChangeLogEntity> changeLogs = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin")
    private List<AssignEntity> assigns = new ArrayList<>();
	
	@OneToMany(mappedBy = "admin")
    private List<CallEntity> calls = new ArrayList<>();
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public List<LoginTimeEntity> getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(List<LoginTimeEntity> loginTime) {
		this.loginTime = loginTime;
	}

	public List<NoteEntity> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteEntity> notes) {
		this.notes = notes;
	}

	public List<ChangeLogEntity> getChangeLogs() {
		return changeLogs;
	}

	public void setChangeLogs(List<ChangeLogEntity> changeLogs) {
		this.changeLogs = changeLogs;
	}

	public List<AssignEntity> getAssigns() {
		return assigns;
	}

	public void setAssigns(List<AssignEntity> assigns) {
		this.assigns = assigns;
	}

	public List<CallEntity> getCalls() {
		return calls;
	}

	public void setCalls(List<CallEntity> calls) {
		this.calls = calls;
	}
	
	
}
