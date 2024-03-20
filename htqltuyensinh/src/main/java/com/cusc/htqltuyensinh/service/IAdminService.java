package com.cusc.htqltuyensinh.service;

import java.util.List;

import com.cusc.htqltuyensinh.dto.AdminDTO;

public interface IAdminService extends IBaseService<AdminDTO>{
	boolean checkPass(long id, String password);
	List<AdminDTO> getListAdminByRole(boolean role);
}
