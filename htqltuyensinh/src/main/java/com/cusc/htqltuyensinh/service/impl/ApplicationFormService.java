package com.cusc.htqltuyensinh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.ApplicationFormConverter;
import com.cusc.htqltuyensinh.dto.ApplicationFormDTO;
import com.cusc.htqltuyensinh.entity.ApplicationFormEntity;
import com.cusc.htqltuyensinh.repository.ApplicationFormRepository;
import com.cusc.htqltuyensinh.service.IApplicationFormService;

@Service
public class ApplicationFormService implements IApplicationFormService{
	
	@Autowired
	private ApplicationFormConverter applicationFormConverter;
	
	@Autowired
	private ApplicationFormRepository applicationFormRepository;

	@Override
	public int totalItem(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ApplicationFormDTO> findAll(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationFormDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationFormDTO save(ApplicationFormDTO dto) {
		ApplicationFormEntity applicationFormEntity;
		applicationFormEntity = applicationFormConverter.toEntity(dto);
		applicationFormRepository.save(applicationFormEntity);
		
		return applicationFormConverter.toDTO(applicationFormEntity);
	}

	@Override
	public void remove(long[] ids) {
		// TODO Auto-generated method stub
		
	}

}
