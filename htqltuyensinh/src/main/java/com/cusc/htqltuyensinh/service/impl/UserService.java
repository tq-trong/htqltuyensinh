package com.cusc.htqltuyensinh.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.FavoriteSubjectConverter;
import com.cusc.htqltuyensinh.converter.SubjectConverter;
import com.cusc.htqltuyensinh.converter.UserConverter;
import com.cusc.htqltuyensinh.dto.UserDTO;
import com.cusc.htqltuyensinh.dto.FavoriteSubjectDTO;
import com.cusc.htqltuyensinh.dto.SubjectDTO;
import com.cusc.htqltuyensinh.entity.FavoriteSubjectEntity;
import com.cusc.htqltuyensinh.entity.SubjectEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;
import com.cusc.htqltuyensinh.repository.FavoriteSubjectRepository;
import com.cusc.htqltuyensinh.repository.SubjectRepository;
import com.cusc.htqltuyensinh.repository.UserRepository;
import com.cusc.htqltuyensinh.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private SubjectConverter subjectConverter;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private FavoriteSubjectConverter favoriteSubjectConverter;
	
	@Autowired
	private FavoriteSubjectRepository favoriteSubjectRepository;
	
	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
	        return userRepository.countByNameContaining(keyword);
	    }
	    return (int) userRepository.count();
	}

	@Override
	public List<UserDTO> findAll(String keyword, Pageable pageable) {
		List<UserEntity> entities;
		if (keyword != null && !keyword.isEmpty()) {
			entities = userRepository.findByNameContaining(keyword, pageable);
	    } else {
	    	entities = userRepository.findAll(pageable).getContent();
	    }
		List<UserDTO> results = entities.stream()
				.map(userConverter::toDTO)
				.collect(Collectors.toList());
		
		return results;
	}

	@Override
	public UserDTO save(UserDTO dto) {
	    UserEntity userEntity;
	    if (dto.getId() != null) {
	        Optional<UserEntity> userOptional = userRepository.findById(dto.getId());
	        if (userOptional.isPresent()) {
	            UserEntity oldUser = userOptional.get();
	            userEntity = userConverter.toEntity(dto, oldUser);
	        } else {
	            return null;
	        }
	    } else {
	        userEntity = userConverter.toEntity(dto);
	    }
	    userEntity = userRepository.save(userEntity);
	    return userConverter.toDTO(userEntity);
	}
	
	

	@Override
	public void remove(long[] ids) {
		for(long item : ids) {
			userRepository.deleteById(item);
		}
		
	}

	@Override
	public List<UserDTO> saveAll(List<UserDTO> userDTOs) {
        List<UserDTO> savedUsers = new ArrayList<>();
        List<UserEntity> entitiesUserToSave = new ArrayList<>();
        
        List<FavoriteSubjectDTO> savedfavoriteSubject= new ArrayList<>();
        List<FavoriteSubjectEntity> favoriteSubjectsToSave = new ArrayList<>();
        
        Set<String> phoneNumbersAdded = new HashSet<>(); // Lưu trữ số điện thoại đã thêm

        for (UserDTO dto : userDTOs) {
        	String phone = dto.getPhone();
            if (!phoneNumbersAdded.contains(phone) && !isPhoneNumberExist(dto.getPhone())) { // Nếu trong Set có sđt trùng nhau thì chỉ lấy 1 và nếu có tồn tại sđt trong csdl thì không insert vào
            	phoneNumbersAdded.add(phone);
                UserEntity userEntity = userConverter.toEntity(dto);
                entitiesUserToSave.add(userEntity);
                
                // Tạo mới các FavoriteSubjectEntity cho mỗi môn học yêu thích
                for (String codeSubject : dto.getFavoriteSubjects()) {
                	SubjectEntity subjectEntity = subjectRepository.findOneByCode(codeSubject);
                	
                	if (subjectEntity != null) {
                        FavoriteSubjectEntity favoriteSubjectEntity = new FavoriteSubjectEntity();
                        favoriteSubjectEntity.setUser(userEntity);
                        favoriteSubjectEntity.setSubject(subjectEntity);
                        favoriteSubjectEntity.setDescription(dto.getDescriptionSubject());
                        favoriteSubjectsToSave.add(favoriteSubjectEntity);
                    } else {
                        // Xử lý trường hợp không tìm thấy môn học với mã codeSubject
                    }
                    
                }
            }
        }

        if (!entitiesUserToSave.isEmpty() && !favoriteSubjectsToSave.isEmpty()) { //Nếu user đó có đăng ký ngành yêu thích thì add user và add favorite subject
            List<UserEntity> savedUserEntities = userRepository.saveAll(entitiesUserToSave);
            savedUsers = savedUserEntities.stream()
                    .map(userConverter::toDTO)
                    .collect(Collectors.toList());
            List<FavoriteSubjectEntity> savedFavoriteSubjectEntity = favoriteSubjectRepository.saveAll(favoriteSubjectsToSave);
            savedfavoriteSubject = savedFavoriteSubjectEntity.stream()
            		.map(favoriteSubjectConverter::toDTO)
            		.collect(Collectors.toList());
        } else { //Nếu user đó không đăng ký ngành yêu thích thì add user
        	List<UserEntity> savedUserEntities = userRepository.saveAll(entitiesUserToSave);
            savedUsers = savedUserEntities.stream()
                    .map(userConverter::toDTO)
                    .collect(Collectors.toList());
        }

        return savedUsers;
    }
	
	private boolean isPhoneNumberExist(String phone) {
        return userRepository.existsByPhone(phone);
    }

	@Override
	public UserDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
