package com.cusc.htqltuyensinh.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "application_form")
public class ApplicationFormEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "courses_id")
    private CourseEntity course;
	
	@Column(name = "notification_channel")
	private String notificationChannel;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
    private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "graduate_result_id")
    private GraduateResultEntity graduateResult;
	
	@ManyToOne
	@JoinColumn(name = "subjects_id")
    private SubjectEntity subject;

	@OneToMany(mappedBy = "applicationForm")
    private List<FileEntity> files = new ArrayList<>();
	
	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public String getNotificationChannel() {
		return notificationChannel;
	}

	public void setNotificationChannel(String notificationChannel) {
		this.notificationChannel = notificationChannel;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public GraduateResultEntity getGraduateResult() {
		return graduateResult;
	}

	public void setGraduateResult(GraduateResultEntity graduateResult) {
		this.graduateResult = graduateResult;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}
	
}
