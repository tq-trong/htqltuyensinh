package com.cusc.htqltuyensinh.dto;

import java.util.Date;

public class ChangeLogDTO extends BaseDTO<ChangeLogDTO>{
	private Date time;
	private String admin;
	private String description;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
