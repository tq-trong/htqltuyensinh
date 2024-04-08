package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.CallDTO;
import com.cusc.htqltuyensinh.entity.CallEntity;

@Component
public class CallConverter {
	@Autowired
	private AdminConverter adminConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private StatusConverter statusConverter;
	
	public CallDTO toDTO(CallEntity entity) {
		CallDTO dto = new CallDTO();
		
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setAdmin(adminConverter.toDTO(entity.getAdmin()));
		dto.setUser(userConverter.toDTO(entity.getUser()));
		dto.setResult(entity.getResult());
		dto.setTimes(entity.getTimes());
		dto.setStatus(statusConverter.toDTO(entity.getStatus()));
		
		return dto;
	}
	
	public CallEntity toEntity(CallDTO dto) {
		CallEntity entity = new CallEntity();
		
		entity.setAdmin(adminConverter.toEntity(dto.getAdmin()));
		entity.setUser(userConverter.toEntity(dto.getUser()));
		entity.setResult(dto.getResult());
		entity.setTimes(dto.getTimes());
		entity.setStatus(statusConverter.toEntity(dto.getStatus()));
		
		return entity;
	}
	
	public CallEntity toEntity(CallEntity entity, CallDTO dto) {
		
		entity.setAdmin(adminConverter.toEntity(dto.getAdmin()));
		entity.setUser(userConverter.toEntity(dto.getUser()));
		entity.setResult(dto.getResult());
		entity.setTimes(dto.getTimes());
		entity.setStatus(statusConverter.toEntity(dto.getStatus()));
		
		return entity;
	}
}
