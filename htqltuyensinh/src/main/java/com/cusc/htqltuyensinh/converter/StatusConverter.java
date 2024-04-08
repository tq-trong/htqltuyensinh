package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.StatusDTO;
import com.cusc.htqltuyensinh.entity.StatusEntity;

@Component
public class StatusConverter {
	public StatusDTO toDTO(StatusEntity entity) {
		StatusDTO dto = new StatusDTO();
		
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public StatusEntity toEntity(StatusDTO dto) {
		StatusEntity entity = new StatusEntity();
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
}
