package com.cusc.htqltuyensinh.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectEntity extends BaseEntity{
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "subject")
    private List<FavoriteSubjectEntity> favoriteSubjects = new ArrayList<>();
	
	@OneToMany(mappedBy = "subject")
    private List<ApplicationFormEntity> applicationForms = new ArrayList<>();
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FavoriteSubjectEntity> getFavoriteSubjects() {
		return favoriteSubjects;
	}

	public void setFavoriteSubjects(List<FavoriteSubjectEntity> favoriteSubjects) {
		this.favoriteSubjects = favoriteSubjects;
	}

	public List<ApplicationFormEntity> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(List<ApplicationFormEntity> applicationForms) {
		this.applicationForms = applicationForms;
	}
	
}
