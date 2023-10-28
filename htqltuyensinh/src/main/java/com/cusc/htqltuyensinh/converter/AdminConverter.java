package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;

@Component
public class AdminConverter {
	public AdminEntity toEntity(AdminDTO dto) {
		AdminEntity entity = new AdminEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setBirthday(dto.getBirthday());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		entity.setGender(dto.isGender());
		entity.setPhone(dto.getPhone());
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setRole(dto.isRole());
		entity.setStatus(dto.isStatus());
		
		return entity;
	}
	
	public AdminDTO toDTO(AdminEntity entity) {
		AdminDTO dto = new AdminDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setBirthday(entity.getBirthday());
		dto.setEmail(entity.getEmail());
		dto.setAddress(entity.getAddress());
		dto.setGender(entity.isGender());
		dto.setPhone(entity.getPhone());
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setRole(entity.isRole());
		dto.setStatus(entity.isStatus());
		
		return dto;
	}
	
	public AdminEntity toEntity(AdminDTO dto, AdminEntity entity) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setBirthday(dto.getBirthday());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		entity.setGender(dto.isGender());
		entity.setPhone(dto.getPhone());
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setRole(dto.isRole());
		entity.setStatus(dto.isStatus());
		
		return entity;
	}
}
