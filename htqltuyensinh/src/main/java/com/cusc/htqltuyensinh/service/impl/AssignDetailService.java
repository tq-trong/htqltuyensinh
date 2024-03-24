package com.cusc.htqltuyensinh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.AssignDetailConverter;
import com.cusc.htqltuyensinh.dto.AssignDetailDTO;
import com.cusc.htqltuyensinh.entity.AssignDetailEntity;
import com.cusc.htqltuyensinh.entity.AssignEntity;
import com.cusc.htqltuyensinh.repository.AssignDetailRepository;
import com.cusc.htqltuyensinh.repository.AssignRepository;
import com.cusc.htqltuyensinh.repository.SchoolRepository;
import com.cusc.htqltuyensinh.repository.UserRepository;
import com.cusc.htqltuyensinh.service.IAssignDetailService;

@Service
public class AssignDetailService implements IAssignDetailService {

	@Autowired
	private AssignDetailRepository assignDetailRepository;
	
	@Autowired
	private AssignRepository assignRepository;
	
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
		if (keyword != null && !keyword.isEmpty()) {
			return assignDetailRepository.countByCode(keyword);
		}
		return (int) assignRepository.count();
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
	
	@Override
	public List<AssignDetailDTO> getListDivideDataView(String keyword, Pageable pageable) {
		List<AssignDetailEntity> entities = new ArrayList<AssignDetailEntity>();
		List<AssignEntity> listAssign;
		if (keyword != null && !keyword.isEmpty())
			listAssign = assignRepository.findByCodeContaining(keyword, pageable);
		else listAssign = assignRepository.findAll(pageable).getContent();
		
		
		for(int i=0; i< listAssign.size(); i++) {
			entities.add(assignDetailRepository.findByAssignId(listAssign.get(i).getId()).get(0));
		}
		List<AssignDetailDTO> results = entities.stream().map(assignDetailConverter::toDTO).collect(Collectors.toList());
		return results;
	}


}
