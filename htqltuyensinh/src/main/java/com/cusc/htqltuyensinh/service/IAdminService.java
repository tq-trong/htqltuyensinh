package com.cusc.htqltuyensinh.service;

import com.cusc.htqltuyensinh.dto.AdminDTO;

public interface IAdminService extends IBaseService<AdminDTO>{
	boolean checkPass(long id, String password);
}
