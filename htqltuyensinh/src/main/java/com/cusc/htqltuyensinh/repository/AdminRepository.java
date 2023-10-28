package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cusc.htqltuyensinh.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>, BaseRepository<AdminEntity>{
	List<AdminEntity> findByCodeContaining(String keyword, Pageable pageable);
	int countByCodeContaining(String keyword);
	AdminEntity findOneByCode(String code);
}
