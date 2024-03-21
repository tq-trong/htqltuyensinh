package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, BaseRepository<UserEntity>{
	
	UserEntity findOneById(long id);
	boolean existsByPhone(String phone);
	int countUserBySchoolCode(String school);
	UserEntity findByPhone(String phone);
	int countUserBySchoolId(long schoolId);
	
	List<UserEntity> findBySchoolId(long id);
	List<UserEntity> findBySchoolCode(String code);
	
}
