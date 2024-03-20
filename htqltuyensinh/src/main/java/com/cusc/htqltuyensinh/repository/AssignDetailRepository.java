package com.cusc.htqltuyensinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.AssignDetailEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;

public interface AssignDetailRepository extends JpaRepository<AssignDetailEntity, Long>{
	boolean existsByUser(UserEntity user);
	AssignDetailEntity findOneByUser(UserEntity user);
	int countUserByAssignCode(String code);
}
