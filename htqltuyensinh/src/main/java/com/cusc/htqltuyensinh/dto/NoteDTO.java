package com.cusc.htqltuyensinh.dto;

import java.util.Date;

public class NoteDTO extends BaseDTO<NoteDTO>{
	private String admin;
	private Date time;
	private String description;
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
