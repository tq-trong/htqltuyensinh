package com.cusc.htqltuyensinh.dto;

public class FavoriteSubjectDTO extends BaseDTO<FavoriteSubjectDTO>{
	private long user;
	private long subject;
	private String description;
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public long getSubject() {
		return subject;
	}
	public void setSubject(long subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
