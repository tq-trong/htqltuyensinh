package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.dto.LoginTimeDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.LoginTimeEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;

@Component
public class LoginTimeConverter {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminConverter adminConverter;
	
	public LoginTimeEntity toEntity(LoginTimeDTO dto) {
		LoginTimeEntity entity = new LoginTimeEntity();
		
		AdminEntity adminEntity = adminRepository.findOneByCode(dto.getAdmin().getCode());
		
		entity.setAdmin(adminEntity);
		entity.setStart(dto.getStart());
		entity.setEnd(dto.getEnd());
		entity.setTotalTime(dto.getTotalTime());
		
		return entity;
	}
	
	public LoginTimeDTO toDTO(LoginTimeEntity entity) {
		LoginTimeDTO dto = new LoginTimeDTO();
		AdminDTO adminDTO =  adminConverter.toDTO(entity.getAdmin());
		if(entity.getId() != null) dto.setId(entity.getId());
		
		
		
		dto.setAdmin(adminDTO);
		dto.setStart(entity.getStart());
		dto.setEnd(entity.getEnd());
		dto.setTotalTime(entity.getTotalTime());
		
		return dto;
	}
	
	public LoginTimeEntity toEntity(LoginTimeDTO dto, LoginTimeEntity entity) {
		AdminEntity adminEntity = adminRepository.findOneByCode(dto.getAdmin().getCode());
		entity.setAdmin(adminEntity);
		entity.setStart(dto.getStart());
		entity.setEnd(dto.getEnd());
		entity.setTotalTime(dto.getTotalTime());
		
		return entity;
	}
}
