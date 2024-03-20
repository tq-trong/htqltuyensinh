package com.cusc.htqltuyensinh.dto;

import java.util.Date;

public class AssignDTO extends BaseDTO<AssignDTO>{
	private AdminDTO admin;
	private String code;
	private Integer quantity;
	private Integer callStatus;
	private Date time;
	
	public AdminDTO getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(Integer callStatus) {
		this.callStatus = callStatus;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
