package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.ProvinceDTO;
import com.cusc.htqltuyensinh.entity.ProvinceEntity;

@Component
public class ProvinceConverter {
	public ProvinceEntity toEntity(ProvinceDTO dto) {
		ProvinceEntity entity = new ProvinceEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
	
	public ProvinceDTO toDTO(ProvinceEntity entity) {
		ProvinceDTO dto = new ProvinceDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		return dto;
	}
}
