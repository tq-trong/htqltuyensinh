package com.cusc.htqltuyensinh.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cusc.htqltuyensinh.converter.MissCallConverter;
import com.cusc.htqltuyensinh.dto.MissCallDTO;
import com.cusc.htqltuyensinh.entity.MissCallEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.MissCallRepository;
import com.cusc.htqltuyensinh.repository.UserRepository;
import com.cusc.htqltuyensinh.service.IMissCallService;

@Service
public class MissCallService implements IMissCallService {

	@Autowired
	private MissCallRepository missCallRepository;

	@Autowired
	private MissCallConverter missCallConverter;
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public int totalItem(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MissCallDTO> findAll(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MissCallDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
		public MissCallDTO save(MissCallDTO dto) {
			UserEntity user = userRepository.findByPhone(dto.getUser());
			if(user != null) {
				MissCallEntity entity = missCallConverter.toEntity(dto);
	
				missCallRepository.save(entity);
	
				return missCallConverter.toDTO(entity);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy số điện thoại trong hệ thống");
			}
		}

	@Override
	public void remove(long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MissCallDTO> showAll() {
		List<MissCallEntity> listEntity = missCallRepository.findAll();

		List<MissCallDTO> results = listEntity.stream().map(missCallConverter::toDTO).collect(Collectors.toList());
		Collections.reverse(results);
		return results;
	}

	@Override
	public List<MissCallDTO> showByUserManager(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOne(long id) {
		missCallRepository.deleteById(id);

	}

}
