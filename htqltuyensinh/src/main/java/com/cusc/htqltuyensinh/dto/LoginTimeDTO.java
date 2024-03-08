package com.cusc.htqltuyensinh.dto;

import java.sql.Timestamp;

public class LoginTimeDTO extends BaseDTO<LoginTimeDTO>{
	private AdminDTO admin;
	private Timestamp start;
	private Timestamp end;
	private Float totalTime;
	
	public AdminDTO getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public Float getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Float totalTime) {
		this.totalTime = totalTime;
	}
}
