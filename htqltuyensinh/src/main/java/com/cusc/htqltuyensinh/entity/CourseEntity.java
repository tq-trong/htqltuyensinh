package com.cusc.htqltuyensinh.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity{
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "course")
    private List<ApplicationFormEntity> applicationForm = new ArrayList<>();
	
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

	public List<ApplicationFormEntity> getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(List<ApplicationFormEntity> applicationForm) {
		this.applicationForm = applicationForm;
	}
	
}
