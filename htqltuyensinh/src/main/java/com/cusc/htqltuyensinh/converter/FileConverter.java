package com.cusc.htqltuyensinh.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.ApplicationFormDTO;
import com.cusc.htqltuyensinh.dto.FileDTO;
import com.cusc.htqltuyensinh.entity.ApplicationFormEntity;
import com.cusc.htqltuyensinh.entity.FileEntity;
import com.cusc.htqltuyensinh.repository.ApplicationFormRepository;

@Component
public class FileConverter {
	
	@Autowired
	private ApplicationFormRepository applicationFormRepository;
	
	@Autowired
	private ApplicationFormConverter applicationFormConverter;
	
	public FileDTO toDTO(FileEntity entity) {
		
		FileDTO dto = new FileDTO();
		ApplicationFormDTO applicationFormDTO = applicationFormConverter.toDTO(entity.getApplicationForm());
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setApplicationForm(applicationFormDTO);
		dto.setFileName(entity.getFile());
		
		return dto;
	}
	
	public FileEntity toEntity(FileDTO dto) {
		FileEntity entity = new FileEntity();
		Optional<ApplicationFormEntity> applicationFormOptional = applicationFormRepository.findById(dto.getApplicationForm().getId());
		ApplicationFormEntity applicationFormEntity = applicationFormOptional.get();
		
		entity.setApplicationForm(applicationFormEntity);
		entity.setFile(dto.getFileName());
		
		return entity;
	}
}
