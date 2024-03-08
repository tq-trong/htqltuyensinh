package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.ChangeLogEntity;
import com.cusc.htqltuyensinh.entity.LoginTimeEntity;

public interface LoginTimeRepository extends JpaRepository<LoginTimeEntity, Long>{
	List<LoginTimeEntity> findByAdminNameContaining(String keyword, Pageable pageable);
	int countByAdminNameContaining(String keyword);
}
