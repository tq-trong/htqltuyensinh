package com.cusc.htqltuyensinh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.dto.AssignDTO;
import com.cusc.htqltuyensinh.dto.AssignDetailDTO;
import com.cusc.htqltuyensinh.dto.UserDTO;
import com.cusc.htqltuyensinh.entity.AssignDetailEntity;
import com.cusc.htqltuyensinh.entity.AssignEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.AssignRepository;
import com.cusc.htqltuyensinh.repository.UserRepository;

@Component
public class AssignDetailConverter {
	
	@Autowired
	private AssignRepository assignRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AssignConverter assignConverter;
	
	@Autowired
	private AdminConverter adminConverter;
	
	@Autowired
	private UserConverter userConverter;

	public AssignDetailEntity toEntity(AssignDetailDTO dto) {
		AssignDetailEntity entity = new AssignDetailEntity();
		
		AssignEntity assign = assignRepository.findOneByCode(dto.getAssignId().getCode());
		UserEntity user = userRepository.findOneById(dto.getUserId().getId());
		
		entity.setAssign(assign);
		entity.setUser(user);
		
		return entity;
	}
	
	public AssignDetailDTO toDTO(AssignDetailEntity entity) {
		AssignDetailDTO dto = new AssignDetailDTO();
		AdminDTO admin = new AdminDTO();
		
		if(entity.getAssign().getAdmin() != null) {
			admin = adminConverter.toDTO(entity.getAssign().getAdmin());
		}
		AssignDTO assignDTO =  assignConverter.toDTO(entity.getAssign());
		assignDTO.setAdmin(admin);
		
		UserDTO userDTO =  userConverter.toDTO(entity.getUser());
		
		if(entity.getId() != null) dto.setId(entity.getId());
		
		dto.setAssignId(assignDTO);
		dto.setUserId(userDTO);
		
		return dto;
	}
	
	public AssignDetailEntity toEntity(AssignDetailDTO dto, AssignDetailEntity entity) {
		AssignEntity assignEntity = assignRepository.findOneByCode(dto.getAssignId().getCode());
		UserEntity userEntity = userRepository.findOneById(dto.getUserId().getId());
		
		entity.setAssign(assignEntity);
		entity.setUser(userEntity);
		
		return entity;
	}
}
