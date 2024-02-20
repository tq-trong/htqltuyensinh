package com.cusc.htqltuyensinh.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.SchoolConverter;
import com.cusc.htqltuyensinh.dto.SchoolDTO;
import com.cusc.htqltuyensinh.entity.SchoolEntity;
import com.cusc.htqltuyensinh.repository.SchoolRepository;
import com.cusc.htqltuyensinh.service.ISchoolService;

@Service
public class SchoolService implements ISchoolService{
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private SchoolConverter schoolConverter;

	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
	        return schoolRepository.countByNameContaining(keyword);
	    }
	    return (int) schoolRepository.count();
	}

	@Override
	public List<SchoolDTO> findAll(String keyword, Pageable pageable) {
		List<SchoolEntity> schoolEntity;
		if (keyword != null && !keyword.isEmpty()) {
	        schoolEntity = schoolRepository.findByNameContaining(keyword, pageable);
	    } else {
	        schoolEntity = schoolRepository.findAll(pageable).getContent();
	    }
		List<SchoolDTO> results = schoolEntity.stream()
				.map(schoolConverter :: toDTO)
				.collect(Collectors.toList());
		return results;
	}

	@Override
	public SchoolDTO save(SchoolDTO dto) {
	    SchoolEntity schoolEntity;
	    if (dto.getId() != null) {
	        Optional<SchoolEntity> schoolOptional = schoolRepository.findById(dto.getId());
	        if (schoolOptional.isPresent()) {
	            SchoolEntity oldSchool = schoolOptional.get();
	            schoolEntity = schoolConverter.toEntity(dto, oldSchool);
	        } else {
	            return null; 
            }
	    } else {
	        schoolEntity = schoolConverter.toEntity(dto);
	    }
	    schoolEntity = schoolRepository.save(schoolEntity);
	    return schoolConverter.toDTO(schoolEntity);
	}

	@Override
	public void remove(long[] ids) {
		for(long item : ids) {
			schoolRepository.deleteById(item);
		}
		
	}

	@Override
	public SchoolDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
