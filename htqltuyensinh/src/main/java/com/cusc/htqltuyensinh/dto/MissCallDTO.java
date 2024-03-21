package com.cusc.htqltuyensinh.dto;

import java.util.Date;

public class MissCallDTO extends BaseDTO<MissCallDTO>{
	private String user;
	private Date time;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
