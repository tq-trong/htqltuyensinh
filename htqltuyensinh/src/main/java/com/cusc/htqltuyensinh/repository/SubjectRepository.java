package com.cusc.htqltuyensinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>{
	SubjectEntity findOneByCode(String code);
}
