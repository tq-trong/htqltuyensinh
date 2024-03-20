package com.cusc.htqltuyensinh.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.AssignConverter;
import com.cusc.htqltuyensinh.converter.AssignDetailConverter;
import com.cusc.htqltuyensinh.dto.AssignDTO;
import com.cusc.htqltuyensinh.dto.AssignDetailDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.AssignDetailEntity;
import com.cusc.htqltuyensinh.entity.AssignEntity;
import com.cusc.htqltuyensinh.entity.ChangeLogEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.AssignDetailRepository;
import com.cusc.htqltuyensinh.repository.AssignRepository;
import com.cusc.htqltuyensinh.repository.SchoolRepository;
import com.cusc.htqltuyensinh.repository.UserRepository;
import com.cusc.htqltuyensinh.service.IAssignDetailService;
import com.cusc.htqltuyensinh.service.IAssignService;

@Service
public class AssignDetailService implements IAssignDetailService {

	@Autowired
	private AssignDetailRepository assignDetailRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private AssignDetailConverter assignDetailConverter;

	@Override
	public int totalItem(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AssignDetailDTO> findAll(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssignDetailDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssignDetailDTO save(AssignDetailDTO dto) {
		AssignDetailEntity entity = new AssignDetailEntity();

		entity = assignDetailConverter.toEntity(dto);
		entity = assignDetailRepository.save(entity);

		return assignDetailConverter.toDTO(entity);

	}

	@Override
	public void remove(long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countUserByAssignCode(String code) {
		return assignDetailRepository.countUserByAssignCode(code);
	}

}
