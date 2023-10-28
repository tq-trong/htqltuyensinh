package com.cusc.htqltuyensinh.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorite_subjects")
public class FavoriteSubjectEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "users_id")
    private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "subjects_id")
    private SubjectEntity subject;
	
	@Column(name = "description")
	private String description;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
