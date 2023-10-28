package com.cusc.htqltuyensinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.SchoolEntity;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long>, BaseRepository<SchoolEntity>{
	SchoolEntity findOneByCode(String code);

}
