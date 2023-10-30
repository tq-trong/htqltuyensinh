package com.cusc.htqltuyensinh.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.ChangeLogConverter;
import com.cusc.htqltuyensinh.dto.ChangeLogDTO;
import com.cusc.htqltuyensinh.entity.ChangeLogEntity;
import com.cusc.htqltuyensinh.repository.ChangeLogRepository;
import com.cusc.htqltuyensinh.service.IChangeLogService;

@Service
public class ChangeLogService implements IChangeLogService{
	
	@Autowired
	private ChangeLogRepository changeLogRepository;
	
	@Autowired ChangeLogConverter changeLogConverter;

	@Override
	public int totalItem(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChangeLogDTO> findAll(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
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

}
