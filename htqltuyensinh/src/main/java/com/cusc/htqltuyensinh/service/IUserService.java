package com.cusc.htqltuyensinh.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cusc.htqltuyensinh.dto.UserDTO;

public interface IUserService extends IBaseService<UserDTO>{
	List<UserDTO> saveAll(List<UserDTO> userDTOs);
	List<UserDTO> processExcelAndSave(MultipartFile file) throws IOException, ParseException;
}
