package com.cusc.htqltuyensinh.api.output;

import com.cusc.htqltuyensinh.dto.AdminDTO;

public class LoginOutput {
	AdminDTO admin;
	Boolean status;
	
	public AdminDTO getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public LoginOutput(AdminDTO admin, Boolean status) {
		this.admin = admin;
		this.status = status;
	}
	
	
	
}
