package com.cusc.htqltuyensinh.converter;

import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.CourseDTO;
import com.cusc.htqltuyensinh.entity.CourseEntity;

@Component
public class CourseConverter {

	public CourseEntity toEntity(CourseDTO dto) {
		
		CourseEntity entity = new CourseEntity();
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
	
	public CourseDTO toDTO(CourseEntity entity) {
		CourseDTO dto = new CourseDTO();
		
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public CourseEntity toEntity(CourseDTO dto, CourseEntity entity) {
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
}
