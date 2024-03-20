package com.cusc.htqltuyensinh.dto;

public class FileDTO extends BaseDTO<FileDTO>{
	private ApplicationFormDTO applicationForm;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ApplicationFormDTO getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationFormDTO applicationForm) {
		this.applicationForm = applicationForm;
	}
	
	
	
}
