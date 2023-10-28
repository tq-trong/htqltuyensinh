package com.cusc.htqltuyensinh.service;

import java.util.List;

import com.cusc.htqltuyensinh.dto.UserDTO;

public interface IUserService extends IBaseService<UserDTO>{
	List<UserDTO> saveAll(List<UserDTO> userDTOs);
}
