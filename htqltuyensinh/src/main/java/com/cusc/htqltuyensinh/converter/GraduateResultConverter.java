package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.GraduateResultDTO;
import com.cusc.htqltuyensinh.entity.GraduateResultEntity;

@Component
public class GraduateResultConverter {
	public GraduateResultDTO toDTO(GraduateResultEntity entity) {
		GraduateResultDTO dto = new GraduateResultDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setGraduateResult(entity.getName());
		
		return dto;
	}
	public GraduateResultEntity toEntity(GraduateResultDTO dto) {
		GraduateResultEntity entity = new GraduateResultEntity();
		entity.setName(dto.getGraduateResult());
		
		return entity;
	}
}
