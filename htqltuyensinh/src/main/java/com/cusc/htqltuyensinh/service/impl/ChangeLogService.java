package com.cusc.htqltuyensinh.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.ChangeLogConverter;
import com.cusc.htqltuyensinh.dto.ChangeLogDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.ChangeLogEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.repository.ChangeLogRepository;
import com.cusc.htqltuyensinh.service.IChangeLogService;

@Service
public class ChangeLogService implements IChangeLogService{
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired ChangeLogConverter changeLogConverter;

	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
			return changeLogRepository.countByDescriptionContaining(keyword);
		}
		return (int) changeLogRepository.count();
	}

	@Override
	public List<ChangeLogDTO> findAll(String keyword, Pageable pageable) {
		List<ChangeLogEntity> entities;
		if (keyword != null && !keyword.isEmpty()) {
			entities = changeLogRepository.findByDescriptionContaining(keyword, pageable);
		} else {
			entities = changeLogRepository.findAll(pageable).getContent();
		}
		List<ChangeLogDTO> results = entities.stream().map(changeLogConverter::toDTO).collect(Collectors.toList());
		return results;
	}
	
	@Override
	public List<ChangeLogDTO> findLogOfSomeone(String keyword, Pageable pageable, Long adminID) {
		List<ChangeLogEntity> entities;
		AdminEntity adminEntity;
	    Optional<AdminEntity> adminOptional = adminRepository.findById(adminID);
	    adminEntity = adminOptional.get();

		if (keyword != null && !keyword.isEmpty()) {
			entities = changeLogRepository.findByAdminIdAndDescriptionContaining(adminID, keyword, pageable);
		} else {
			entities = changeLogRepository.findByAdmin(adminEntity, pageable);
		}
		List<ChangeLogDTO> results = entities.stream().map(changeLogConverter::toDTO).collect(Collectors.toList());
		return results;
	}

	@Override
	public ChangeLogDTO save(ChangeLogDTO dto) {
		
		ChangeLogEntity entity = new ChangeLogEntity();
		
		entity = changeLogConverter.toEntity(dto);
		entity.setTime(new Date());
		entity = changeLogRepository.save(entity);
		
		return changeLogConverter.toDTO(entity);
	}

	@Override
	public void remove(long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChangeLogDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long totalItemByAdmin(String keyword, Long adminID) {
		AdminEntity adminEntity;
	    Optional<AdminEntity> adminOptional = adminRepository.findById(adminID);
	    adminEntity = adminOptional.get();
	    
		if (keyword != null && !keyword.isEmpty()) {
			return changeLogRepository.countByAdminAndDescriptionContaining(adminID, keyword);
		}
		return (long) changeLogRepository.countByAdmin(adminEntity);
	}

}
