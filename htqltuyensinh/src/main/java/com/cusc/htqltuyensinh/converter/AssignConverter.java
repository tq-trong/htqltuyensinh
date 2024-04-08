package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.dto.AssignDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.AssignEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;

@Component
public class AssignConverter {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminConverter adminConverter;

	public AssignEntity toEntity(AssignDTO dto) {
		AssignEntity entity = new AssignEntity();
		AdminEntity adminEntity = new AdminEntity();

		if (dto.getAdmin() != null)
			adminEntity = adminRepository.findOneByCode(dto.getAdmin().getCode());
		else
			adminEntity = null;

		entity.setAdmin(adminEntity);
		entity.setCode(dto.getCode());
		entity.setTime(dto.getTime());
		entity.setQuantity(dto.getQuantity());
		entity.setCallStatus(dto.getCallStatus());

		return entity;
	}

	public AssignDTO toDTO(AssignEntity entity) {
		AssignDTO dto = new AssignDTO();
		AdminDTO adminDTO = new AdminDTO();

		if (entity.getAdmin() != null)
			adminDTO = adminConverter.toDTO(entity.getAdmin());
		else
			adminDTO = null;
		if (entity.getId() != null)
			dto.setId(entity.getId());

		dto.setAdmin(adminDTO);
		dto.setCode(entity.getCode());
		dto.setTime(entity.getTime());
		dto.setQuantity(entity.getQuantity());
		dto.setCallStatus(entity.getCallStatus());

		return dto;
	}

	public AssignEntity toEntity(AssignDTO dto, AssignEntity entity) {
		AdminEntity adminEntity = new AdminEntity();

		if (dto.getAdmin() != null) adminEntity = adminRepository.findOneByCode(dto.getAdmin().getCode());
		else adminEntity = null;
		
		entity.setAdmin(adminEntity);
		entity.setCode(dto.getCode());
		entity.setTime(dto.getTime());
		entity.setQuantity(dto.getQuantity());
		entity.setCallStatus(dto.getCallStatus());

		return entity;
	}
}
