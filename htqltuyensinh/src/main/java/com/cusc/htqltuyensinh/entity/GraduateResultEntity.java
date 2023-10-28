package com.cusc.htqltuyensinh.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "graduate_result")
public class GraduateResultEntity extends BaseEntity{
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "graduateResult")
    private List<ApplicationFormEntity> applicationForms = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ApplicationFormEntity> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(List<ApplicationFormEntity> applicationForms) {
		this.applicationForms = applicationForms;
	}
	
}
