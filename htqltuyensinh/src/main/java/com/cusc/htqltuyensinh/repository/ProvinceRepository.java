package com.cusc.htqltuyensinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.ProvinceEntity;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long>{
	ProvinceEntity findOneByCode(String code);
}
