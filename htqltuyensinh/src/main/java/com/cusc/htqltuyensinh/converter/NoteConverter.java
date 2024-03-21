package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.NoteDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.NoteEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;

@Component
public class NoteConverter {
	@Autowired
	private AdminConverter adminConverter;
	
	@Autowired
	private AdminRepository adminRepository;
	
	public NoteEntity toEntity(NoteDTO dto) {
		NoteEntity entity = new NoteEntity();
		AdminEntity adminEntity = adminRepository.findOneByCode(dto.getAdmin());
		
		entity.setAdmin(adminEntity);
		entity.setDescription(dto.getDescription());
		entity.setTime(dto.getTime());
		
		return entity;
	}
	
	public NoteDTO toDTO(NoteEntity entity) {
		NoteDTO dto = new NoteDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setAdmin(entity.getAdmin().getName());
		dto.setTime(entity.getTime());
		dto.setDescription(entity.getDescription());
		
		return dto;
	}
}
