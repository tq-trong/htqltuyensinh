package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.ChangeLogDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.ChangeLogEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;

@Component
public class ChangeLogConverter {
	@Autowired
	private AdminRepository adminRepository;
	
	public ChangeLogEntity toEntity(ChangeLogDTO dto) {
		
		ChangeLogEntity entity = new ChangeLogEntity();
		AdminEntity adminEntity = adminRepository.findOneByCode(dto.getAdmin());
		
		entity.setTime(dto.getTime());
		entity.setDescription(dto.getDescription());
		entity.setAdmin(adminEntity);
		
		return entity;
	}
	
	public ChangeLogDTO toDTO(ChangeLogEntity entity) {
		
		ChangeLogDTO dto = new ChangeLogDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		
		dto.setTime(entity.getTime());
		dto.setDescription(entity.getDescription());
		dto.setAdmin(entity.getAdmin().getCode());
		
		return dto;
	}
	
	public ChangeLogEntity toEntity(ChangeLogDTO dto, ChangeLogEntity entity) {
		
		AdminEntity adminEntity = adminRepository.findOneByCode(dto.getAdmin());
		
		entity.setTime(dto.getTime());
		entity.setDescription(dto.getDescription());
		entity.setAdmin(adminEntity);
		
		return entity;
	}
}
