package com.cusc.htqltuyensinh.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.cusc.htqltuyensinh.dto.UserDTO;

public interface IUserService extends IBaseService<UserDTO>{
	List<UserDTO> saveAll(List<UserDTO> userDTOs);
	List<UserDTO> processExcelAndSave(MultipartFile file) throws IOException, ParseException;
	int countUserBySchool(String school);
	int countUserBySchoolId(long schoolId);
	List<UserDTO> findUserBySchoolId(long id);
	List<UserDTO> findAllByAssignId(String keyword, Pageable pageable, long id);
}
