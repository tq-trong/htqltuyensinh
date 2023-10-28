package com.cusc.htqltuyensinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, BaseRepository<UserEntity>{
	
	boolean existsByPhone(String phone);
	
}
