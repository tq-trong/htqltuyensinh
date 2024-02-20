package com.cusc.htqltuyensinh.api.output;

import com.cusc.htqltuyensinh.dto.AdminDTO;

public class AdminOutput extends AbstractOutput<AdminDTO>{
	private AdminDTO admin;

	public AdminDTO getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	
	
}
