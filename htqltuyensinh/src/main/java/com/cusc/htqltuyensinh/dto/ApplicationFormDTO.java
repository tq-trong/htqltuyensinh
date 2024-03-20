package com.cusc.htqltuyensinh.dto;

import java.util.List;

public class ApplicationFormDTO extends BaseDTO<ApplicationFormDTO>{
	private CourseDTO course;
	private String notificationChannel;
	private UserDTO user;
	private SubjectDTO subject;
	private GraduateResultDTO graduateResult;
	private List<FileDTO> files;
	
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	public String getNotificationChannel() {
		return notificationChannel;
	}
	public void setNotificationChannel(String notificationChannel) {
		this.notificationChannel = notificationChannel;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public GraduateResultDTO getGraduateResult() {
		return graduateResult;
	}
	public void setGraduateResult(GraduateResultDTO graduateResult) {
		this.graduateResult = graduateResult;
	}
	public List<FileDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}
	
	
}
