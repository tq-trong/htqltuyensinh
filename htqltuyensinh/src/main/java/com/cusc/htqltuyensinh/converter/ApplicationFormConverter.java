package com.cusc.htqltuyensinh.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.ApplicationFormDTO;
import com.cusc.htqltuyensinh.dto.FileDTO;
import com.cusc.htqltuyensinh.entity.ApplicationFormEntity;
import com.cusc.htqltuyensinh.entity.FileEntity;

@Component
public class ApplicationFormConverter {
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private CourseConverter courseConverter;
	
	@Autowired
	private SubjectConverter subjectConverter;
	
	@Autowired
	private GraduateResultConverter graduateResultConverter;
	
	@Autowired
	private FileConverter fileConverter;
	
	public ApplicationFormEntity toEntity(ApplicationFormDTO dto) {
		ApplicationFormEntity entity = new ApplicationFormEntity();
		
		List<FileEntity> fileEntities = new ArrayList<>();
		for (FileDTO fileDTO : dto.getFiles()) {
	        FileEntity fileEntity = fileConverter.toEntity(fileDTO);
	        fileEntities.add(fileEntity);
	    }
		
		entity.setUser(userConverter.toEntity(dto.getUser()));
		entity.setNotificationChannel(dto.getNotificationChannel());
		entity.setCourse(courseConverter.toEntity(dto.getCourse()));
		entity.setSubject(subjectConverter.toEntity(dto.getSubject()));
		entity.setGraduateResult(graduateResultConverter.toEntity(dto.getGraduateResult()));
		entity.setFiles(fileEntities);
		return entity;
	}
	
	public ApplicationFormDTO toDTO(ApplicationFormEntity entity) {
		ApplicationFormDTO dto = new ApplicationFormDTO();
		dto.setUser(userConverter.toDTO(entity.getUser()));
		dto.setNotificationChannel(entity.getNotificationChannel());
		dto.setCourse(courseConverter.toDTO(entity.getCourse()));
		dto.setSubject(subjectConverter.toDTO(entity.getSubject()));
		dto.setGraduateResult(graduateResultConverter.toDTO(entity.getGraduateResult()));
		
		List<FileDTO> fileDTOs = new ArrayList<>();
		for (FileEntity fileEntity : entity.getFiles()) {
	        FileDTO fileDTO = fileConverter.toDTO(fileEntity);
	        fileDTOs.add(fileDTO);
	    }
		
		dto.setFiles(fileDTOs);
		
		return dto;
	}
}
