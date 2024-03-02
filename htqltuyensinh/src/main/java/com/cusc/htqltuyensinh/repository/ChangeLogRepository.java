package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.ChangeLogEntity;

public interface ChangeLogRepository extends JpaRepository<ChangeLogEntity, Long>{
	List<ChangeLogEntity> findByDescriptionContaining(String keyword, Pageable pageable);
	
	@Query("SELECT c FROM ChangeLogEntity c WHERE c.admin.id = :adminId AND c.description LIKE %:keyword%")
	List<ChangeLogEntity> findByAdminIdAndDescriptionContaining(@Param("adminId") Long adminId, @Param("keyword") String keyword, Pageable pageable);
	
	int countByDescriptionContaining(String keyword);
	List<ChangeLogEntity> findByAdmin(AdminEntity admin, Pageable pageable);
	
	@Query("SELECT COUNT(c) FROM ChangeLogEntity c WHERE c.admin.id = :adminId AND c.description LIKE %:keyword%")
    long countByAdminAndDescriptionContaining(@Param("adminId") Long adminId, @Param("keyword") String keyword);
	
	long countByAdmin(AdminEntity admin);

}
