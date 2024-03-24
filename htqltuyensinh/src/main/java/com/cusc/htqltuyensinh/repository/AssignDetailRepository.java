package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cusc.htqltuyensinh.entity.AssignDetailEntity;
import com.cusc.htqltuyensinh.entity.UserEntity;

public interface AssignDetailRepository extends JpaRepository<AssignDetailEntity, Long>{
	boolean existsByUser(UserEntity user);
	AssignDetailEntity findOneByUser(UserEntity user);
	int countUserByAssignCode(String code);
	List<AssignDetailEntity> findByAssignId(long id);
	
	@Query("SELECT COUNT(DISTINCT ad.assign) FROM AssignDetailEntity ad, AssignEntity a, UserEntity u WHERE ad.assign.id = a.id AND ad.user.id = u.id AND a.code LIKE %:code% OR u.school.name LIKE %:code%")
	int countByCode(@Param("code")String code);
	
	@Query("SELECT ad FROM AssignDetailEntity ad WHERE ad.assign.id = :id")
	List<AssignDetailEntity> getListByAssignId(@Param("id") long id);
}
