package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.SchoolDTO;
import com.cusc.htqltuyensinh.entity.SchoolEntity;


@Component
public class SchoolConverter {
	
	
	public SchoolEntity toEntity(SchoolDTO dto) {
		SchoolEntity entity = new SchoolEntity();
		//ProvinceEntity provinceEntity = provinceRepository.findOneByCode(dto.getProvince());
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setProvince(dto.getProvince());
		
		return entity;
	}
	
	public SchoolDTO toDTO(SchoolEntity entity) {
		SchoolDTO dto = new SchoolDTO();
		//ProvinceEntity provinceEntity = provinceRepository.findOneByCode(entity.getProvince().getCode());
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setProvince(entity.getProvince());
		
		return dto;
	}
	
	public SchoolEntity toEntity(SchoolDTO dto, SchoolEntity entity) {
		//ProvinceEntity provinceEntity = provinceRepository.findOneByCode(dto.getProvince());
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setProvince(dto.getProvince());
		
		return entity;
	}
}
