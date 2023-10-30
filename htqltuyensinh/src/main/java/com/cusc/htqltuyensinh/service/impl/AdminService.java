package com.cusc.htqltuyensinh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.AdminConverter;
import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.service.IAdminService;

@Service
public class AdminService implements IAdminService{
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminConverter adminConverter;
	
	@Override
	public AdminDTO save(AdminDTO dto) { 
		AdminEntity adminEntity = new AdminEntity();
		if(dto.getId() != null) {
			AdminEntity oldAdmin = adminRepository.findOne(dto.getId());
			adminEntity = adminConverter.toEntity(dto, oldAdmin);
		} else {
			adminEntity = adminConverter.toEntity(dto);
		}
		adminEntity = adminRepository.save(adminEntity);
		return adminConverter.toDTO(adminEntity);
	}

	@Override
	public List<AdminDTO> findAll(String keyword, Pageable pageable) { //Get list Admin
		List<AdminEntity> entities;
		if (keyword != null && !keyword.isEmpty()) {
			entities = adminRepository.findByNameContaining(keyword, pageable);
			if(entities.isEmpty() || entities == null) {
				entities = adminRepository.findByCodeContaining(keyword, pageable);
			}
	    } else {
	    	entities = adminRepository.findAll(pageable).getContent();
	    }
		List<AdminDTO> results = entities.stream()
				.map(adminConverter::toDTO)
				.collect(Collectors.toList());
		return results;
	}

	@Override
	public void remove(long[] ids) {
		for(long item:ids) {
			adminRepository.delete(item);
		}
	}

	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
	        return adminRepository.countByNameContaining(keyword);
	    }
		return (int) adminRepository.count();
	}

	
	@Override
	public AdminDTO login(AdminDTO adminDTO) { 
		return checkLogin(adminDTO.getUserName(), adminDTO.getPassword());
	}

	public AdminDTO checkLogin(String userName, String password) {
		AdminEntity adminEntity = adminRepository.findByUserNameAndPassword(userName, password);
		
		if (adminEntity != null) {
	        return adminConverter.toDTO(adminEntity);
	    } else {
	        return new AdminDTO();
	    }
	}
}
