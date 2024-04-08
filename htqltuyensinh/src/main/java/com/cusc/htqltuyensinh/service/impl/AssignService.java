package com.cusc.htqltuyensinh.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.AssignConverter;
import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.dto.AssignDTO;
import com.cusc.htqltuyensinh.dto.AssignDetailDTO;
import com.cusc.htqltuyensinh.dto.SchoolDTO;
import com.cusc.htqltuyensinh.dto.UserDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.AssignDetailEntity;
import com.cusc.htqltuyensinh.entity.AssignEntity;
import com.cusc.htqltuyensinh.entity.LoginTimeEntity;
import com.cusc.htqltuyensinh.entity.SchoolEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.repository.AssignDetailRepository;
import com.cusc.htqltuyensinh.repository.AssignRepository;
import com.cusc.htqltuyensinh.repository.SchoolRepository;
import com.cusc.htqltuyensinh.repository.UserRepository;
import com.cusc.htqltuyensinh.service.IAssignService;

@Service
public class AssignService implements IAssignService {

	@Autowired
	private AssignRepository assignRepository;

	@Autowired
	private AssignDetailRepository assignDetailRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private AssignConverter assignConverter;

	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
			return assignRepository.countByCode(keyword);
		}
		return (int) assignRepository.count();
	}

	@Override
	public List<AssignDTO> findAll(String keyword, Pageable pageable) {
		List<AssignEntity> entities;
		if (keyword != null && !keyword.isEmpty()) {
			entities = assignRepository.findByCodeContaining(keyword, pageable);
			
		} else {
			entities = assignRepository.findAll(pageable).getContent();
		}
		List<AssignDTO> results = entities.stream().map(assignConverter::toDTO).collect(Collectors.toList());
		return results;
	}

	@Override
	public AssignDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssignDTO save(AssignDTO dto) {
		Timestamp now = new Timestamp(new Date().getTime());
		AssignEntity entity;
		if (dto.getId() != null) {
			Optional<AssignEntity> assignOptional = assignRepository.findById(dto.getId());
			if (assignOptional.isPresent()) {
				entity = assignOptional.get();
				if(dto.getCallStatus() != null ) {
					entity.setCallStatus(dto.getCallStatus());
				}else {
					entity.setAdmin(adminRepository.findOneByCode(dto.getAdmin().getCode()));
					entity.setTime(now);
				}
				assignRepository.save(entity);
			}

		} else {
			int totalUser = userService.countUserBySchool(dto.getCode());
			int quantity = totalUser / dto.getQuantity();
			int countUser = 0;
			int index = 0;
			
			int mod = totalUser % dto.getQuantity();
			if(mod > quantity) quantity = quantity + (mod/quantity);
			
			List<UserEntity> userList = userRepository
					.findBySchoolId(schoolRepository.findOneByCode(dto.getCode()).getId());
			List<UserEntity> checkedList = new ArrayList<UserEntity>();
			for (UserEntity user : userList) {
				if (!assignDetailRepository.existsByUser(user))
					checkedList.add(user);
			}

			for (int i = 1; i <= dto.getQuantity(); i++) {

				entity = assignConverter.toEntity(dto);
				entity.setCode(createCode(dto.getCode()));
				if (i == dto.getQuantity())
					entity.setQuantity(totalUser - countUser);
				else
					entity.setQuantity(quantity);

				entity.setCallStatus(0);
				assignRepository.save(entity);
				for (int j = 0; j < entity.getQuantity(); j++) {
					AssignDetailEntity assignDetailEntity = new AssignDetailEntity();
					
					assignDetailEntity.setAssign(entity);
					assignDetailEntity.setUser(checkedList.get(index));

					assignDetailRepository.save(assignDetailEntity);
					index++;
				}
				countUser = countUser + quantity;

			}
		}
		return null;
	}

	@Override
	public void remove(long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countByCode(String code) {
		return assignRepository.countByCode(code);
	}

	public String createCode(String school) {
		List<String> checkCode = assignRepository.checkExistCode(school);
		String fullcode = "";

		if (!checkCode.isEmpty()) {
			String lastCode = checkCode.get(0);
			String[] arr = lastCode.split("-");
			String code = arr[arr.length - 1];
			int num = Integer.parseInt(code.substring(2)) + 1;
			fullcode = school + "-DS" + (String.format("%02d", num));
		} else
			fullcode = school + "-DS01";

		return fullcode;
	}

	@Override
	public List<AssignDTO> getListAssignBySchool(String code) {
		List<AssignEntity> entities;

		entities = assignRepository.getListAssignBySchool(code);
		List<AssignDTO> results = entities.stream().map(assignConverter::toDTO).collect(Collectors.toList());
		return results;
	}

	@Override
	public AssignDTO findOneByCode(String code) {
		AssignEntity entitiy = assignRepository.findOneByCode(code);
		AssignDTO result = assignConverter.toDTO(entitiy);
		return result;
	}

	@Override
	public List<Object[]> getListDivideDataView(String code) {
		
		return assignRepository.getListDivideDataView(code);
	}

//	@Override
//	public int getTotalAssignQuantity(long admin) {
//		return assignRepository.getTotalAssignQuantityByAdmin(admin);
//	}

}
