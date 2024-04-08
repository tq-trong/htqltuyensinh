package com.cusc.htqltuyensinh.dto;

public class CallDTO extends BaseDTO<CallDTO>{
	private UserDTO user;
	private AdminDTO admin;
	private StatusDTO status;
	private int times;
	private String result;
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public AdminDTO getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	public StatusDTO getStatus() {
		return status;
	}
	public void setStatus(StatusDTO status) {
		this.status = status;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
