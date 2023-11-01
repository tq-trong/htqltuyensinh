package com.cusc.htqltuyensinh.service;

import com.cusc.htqltuyensinh.api.output.LoginOutput;
import com.cusc.htqltuyensinh.dto.AdminDTO;

public interface IAdminService extends IBaseService<AdminDTO>{
	 LoginOutput login(AdminDTO dto);
}
