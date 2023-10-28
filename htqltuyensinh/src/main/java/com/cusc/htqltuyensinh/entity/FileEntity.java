package com.cusc.htqltuyensinh.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class FileEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "application_form_id")
    private ApplicationFormEntity applicationForm;
	
	@Column(name = "file")
	private String file;

	public ApplicationFormEntity getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationFormEntity applicationForm) {
		this.applicationForm = applicationForm;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
