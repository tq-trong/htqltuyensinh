package com.cusc.htqltuyensinh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.repository.StatusRepository;
import com.cusc.htqltuyensinh.service.IStatusService;

@Service
public class StatusService implements IStatusService{
	
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Object[]> getAllStatusAndCount() {
		return statusRepository.getStatusCountsAndTotal();
	}

}
