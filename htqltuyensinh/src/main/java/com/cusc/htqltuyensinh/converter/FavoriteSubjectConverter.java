package com.cusc.htqltuyensinh.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.FavoriteSubjectDTO;
import com.cusc.htqltuyensinh.entity.FavoriteSubjectEntity;
import com.cusc.htqltuyensinh.entity.SubjectEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.UserRepository;
import com.cusc.htqltuyensinh.repository.SubjectRepository;

@Component
public class FavoriteSubjectConverter {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public FavoriteSubjectEntity toEntity(FavoriteSubjectDTO dto) {
		FavoriteSubjectEntity entity = new FavoriteSubjectEntity();
		Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser());
		UserEntity userEntity = userEntityOptional.get();
		
		Optional<SubjectEntity> subjectEntityOptional = subjectRepository.findById(dto.getSubject());
		SubjectEntity subjectEntity = subjectEntityOptional.get();
		
		entity.setUser(userEntity);
		entity.setSubject(subjectEntity);
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
	
	public FavoriteSubjectDTO toDTO(FavoriteSubjectEntity entity) {
		FavoriteSubjectDTO dto = new FavoriteSubjectDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		
		dto.setUser(entity.getUser().getId());
		dto.setSubject(entity.getSubject().getId());
		dto.setDescription(entity.getDescription());
		return dto;
	}
	
	public FavoriteSubjectEntity toEntity(FavoriteSubjectDTO dto, FavoriteSubjectEntity entity) {
		UserEntity userEntity = userRepository.getById(dto.getUser());
		SubjectEntity subjectEntity = subjectRepository.getById(dto.getSubject());
		
		entity.setUser(userEntity);
		entity.setSubject(subjectEntity);
		entity.setDescription(dto.getDescription());
		return entity;
	}
}
