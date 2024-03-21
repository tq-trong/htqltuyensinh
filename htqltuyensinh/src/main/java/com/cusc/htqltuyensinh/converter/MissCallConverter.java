package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.MissCallDTO;
import com.cusc.htqltuyensinh.entity.MissCallEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.UserRepository;

@Component
public class MissCallConverter {
	@Autowired
	private UserRepository userRepository;
	
	public MissCallDTO toDTO(MissCallEntity entity) {
		MissCallDTO dto = new MissCallDTO();
		
		if(entity.getId() != null) dto.setId(entity.getId());
		
		dto.setUser(entity.getUser().getPhone());
		dto.setTime(entity.getTime());
		
		return dto;
	}
	
	public MissCallEntity toEntity(MissCallDTO dto) {
		MissCallEntity entity = new MissCallEntity();
		UserEntity userEntity = userRepository.findByPhone(dto.getUser());
		
		entity.setTime(dto.getTime());
		entity.setUser(userEntity);
		
		return entity;
	}
}
