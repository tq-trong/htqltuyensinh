package com.cusc.htqltuyensinh.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.LoginTimeConverter;
import com.cusc.htqltuyensinh.dto.ChangeLogDTO;
import com.cusc.htqltuyensinh.dto.LoginTimeDTO;
import com.cusc.htqltuyensinh.entity.ChangeLogEntity;
import com.cusc.htqltuyensinh.entity.LoginTimeEntity;
import com.cusc.htqltuyensinh.repository.LoginTimeRepository;
import com.cusc.htqltuyensinh.service.ILoginTimeService;

@Service
public class LoginTimeService implements ILoginTimeService {
	
	@Autowired
	private LoginTimeRepository loginTimeRepository;

	@Autowired
	private LoginTimeConverter loginTimeConverter;
	
	@Override
	public LoginTimeDTO save(LoginTimeDTO dto) {
		 LoginTimeEntity entity;
		 Timestamp now = new Timestamp(new Date().getTime());
		 
		    if (dto.getId() != null) {
		        Optional<LoginTimeEntity> loginTimeOptional = loginTimeRepository.findById(dto.getId());
		        if (loginTimeOptional.isPresent()) {
		        	LoginTimeEntity oldLoginTime = loginTimeOptional.get();
		            entity = loginTimeConverter.toEntity(dto, oldLoginTime);
		            entity.setEnd(now);
		            entity.setTotalTime((float)(entity.getEnd().getTime() - entity.getStart().getTime()) / (3600 * 1000));
		        } else {
		            return null;
		        }
		    } else {
		        entity = loginTimeConverter.toEntity(dto);
//		        entity.setStart(now);
		        entity.setEnd(now);
		        entity.setTotalTime((float)(entity.getEnd().getTime() - entity.getStart().getTime()) / (3600 * 1000));
		    }
		    
		    entity = loginTimeRepository.save(entity);
		    return loginTimeConverter.toDTO(entity);
	}
	
//	@Override
//	public List<LoginTimeDTO> findAll(String keyword, Pageable pageable) { // Get list Admin
//		List<LoginTimeEntity> entities;
//		if (keyword != null && !keyword.isEmpty()) {
//			entities = loginTimeRepository.findByNameContaining(keyword, pageable);
//			if (entities.isEmpty() || entities == null) {
//				entities = loginTimeRepository.findByCodeContaining(keyword, pageable);
//			}
//		} else {
//			entities = loginTimeRepository.findAll(pageable).getContent();
//		}
//		List<LoginTimeDTO> results = entities.stream().map(loginTimeConverter::toDTO).collect(Collectors.toList());
//		
//		return results;
//	}

	@Override
	public void remove(long[] ids) {
		
	}

	
	

	@Override
	public LoginTimeDTO findById(long id) {
		LoginTimeEntity loginTimeEntity;
	    Optional<LoginTimeEntity> loginTimeOptional = loginTimeRepository.findById(id);
	    loginTimeEntity = loginTimeOptional.get();
	    return loginTimeConverter.toDTO(loginTimeEntity);
	}

	@Override
	public List<LoginTimeDTO> findAll(String keyword, Pageable pageable) {
		List<LoginTimeEntity> entities;
		if (keyword != null && !keyword.isEmpty()) {
			entities = loginTimeRepository.findByAdminNameContaining(keyword, pageable);
		} else {
			entities = loginTimeRepository.findAll(pageable).getContent();
		}
		List<LoginTimeDTO> results = entities.stream().map(loginTimeConverter::toDTO).collect(Collectors.toList());
		return results;

	}

	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
			return loginTimeRepository.countByAdminNameContaining(keyword);
		}
		return (int) loginTimeRepository.count();
	}

}
