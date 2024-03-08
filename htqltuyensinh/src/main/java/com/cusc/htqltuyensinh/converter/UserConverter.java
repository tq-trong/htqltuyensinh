package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.UserDTO;
import com.cusc.htqltuyensinh.entity.SchoolEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.SchoolRepository;

@Component
public class UserConverter {
	
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	public UserEntity toEntity(UserDTO dto) {

		UserEntity entity = new UserEntity();
		
		SchoolEntity schoolEntity = schoolRepository.findOneByCode(dto.getSchool());

		entity.setName(dto.getName());
		entity.setBirthday(dto.getBirthday());
		entity.setJob(dto.getJob());
		entity.setProvince(dto.getProvince());
		entity.setSchool(schoolEntity);
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setFatherPhone(dto.getFatherPhone());
		entity.setMotherPhone(dto.getMotherPhone());
		entity.setZalo(dto.getZalo());
		entity.setFacebook(dto.getFacebook());
		entity.setGatherDescription(dto.getGatherDescription());
		entity.setStatus(dto.isStatus());
		entity.setGender(dto.isGender());

		return entity;
	}

	public UserDTO toDTO(UserEntity entity) {

		UserDTO dto = new UserDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setBirthday(entity.getBirthday());
		dto.setJob(entity.getJob());
		dto.setProvince(entity.getProvince());
		dto.setSchool(entity.getSchool().getCode());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setFatherPhone(entity.getFatherPhone());
		dto.setMotherPhone(entity.getMotherPhone());
		dto.setZalo(entity.getZalo());
		dto.setFacebook(entity.getFacebook());
		dto.setGatherDescription(entity.getGatherDescription());
		dto.setStatus(entity.isStatus());

		return dto;
	}

	public UserEntity toEntity(UserDTO dto, UserEntity entity) {

		//ProvinceEntity provinceEntity = provinceRepository.findOneByCode(dto.getProvince());
		SchoolEntity schoolEntity = schoolRepository.findOneByCode(dto.getSchool());
		
		entity.setName(dto.getName());
		entity.setBirthday(dto.getBirthday());
		entity.setJob(dto.getJob());
		entity.setProvince(dto.getProvince());
		entity.setSchool(schoolEntity);
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setFatherPhone(dto.getFatherPhone());
		entity.setMotherPhone(dto.getMotherPhone());
		entity.setZalo(dto.getZalo());
		entity.setFacebook(dto.getFacebook());
		entity.setGatherDescription(dto.getGatherDescription());
		entity.setStatus(dto.isStatus());

		return entity;
	}
}
