package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.SubjectDTO;
import com.cusc.htqltuyensinh.entity.SubjectEntity;

@Component
public class SubjectConverter {
	public SubjectEntity toEntity(SubjectDTO dto) {
		SubjectEntity entity = new SubjectEntity();
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
	
	public SubjectDTO toDTO(SubjectEntity entity) {
		SubjectDTO dto = new SubjectDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public SubjectEntity toEntity(SubjectEntity entity, SubjectDTO dto) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
}
