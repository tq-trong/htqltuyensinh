package com.cusc.htqltuyensinh.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.CourseConverter;
import com.cusc.htqltuyensinh.dto.CourseDTO;
import com.cusc.htqltuyensinh.entity.CourseEntity;
import com.cusc.htqltuyensinh.repository.CourseRepository;
import com.cusc.htqltuyensinh.service.ICourseService;

@Service
public class CourseService implements ICourseService{
	
	@Autowired
	private CourseConverter courseConverter;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public int totalItem(String keyword) {
		if(keyword != null && !keyword.isEmpty())
			return courseRepository.countByNameContaining(keyword);
		return (int) courseRepository.count();
	}

	@Override
	public List<CourseDTO> findAll(String keyword, Pageable pageable) {
		List<CourseEntity> entities;
		if(keyword != null && !keyword.isEmpty()) {
			entities = courseRepository.findByNameContaining(keyword, pageable);
			if(entities.isEmpty() || entities == null) {
				entities = courseRepository.findByCodeContaining(keyword, pageable);
			}
		} else {
			entities = courseRepository.findAll(pageable).getContent();
		}
		List<CourseDTO> results = entities.stream()
								  .map(courseConverter :: toDTO)
								  .collect(Collectors.toList());
		return results;
	}

	@Override
	public CourseDTO save(CourseDTO dto) {
	    CourseEntity entity;
	    if (dto.getId() != null) {
	        Optional<CourseEntity> courseOptional = courseRepository.findById(dto.getId());
	        if (courseOptional.isPresent()) {
	            CourseEntity oldCourse = courseOptional.get();
	            entity = courseConverter.toEntity(dto, oldCourse);
	        } else {
	            return null;
	        }
	    } else {
	        entity = courseConverter.toEntity(dto);
	    }
	    entity = courseRepository.save(entity);
	    return courseConverter.toDTO(entity);
	}

	@Override
	public void remove(long[] ids) {
		for(long item : ids) {
			courseRepository.deleteById(item);
		}
		
	}

}
