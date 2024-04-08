package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cusc.htqltuyensinh.entity.AssignEntity;

public interface AssignRepository extends JpaRepository<AssignEntity, Long>{
	List<AssignEntity> findByCodeContaining(String keyword, Pageable pageable);
	AssignEntity findOneByCode(String code);
	int countByCode(String code);
	
	@Query("SELECT code FROM AssignEntity a WHERE a.code LIKE %:code% ORDER BY a.code DESC")
	List<String> checkExistCode(@Param("code") String code); 

	@Query("SELECT a FROM AssignEntity a WHERE a.code LIKE %:code% AND a.admin = null")
	List<AssignEntity> getListAssignBySchool(@Param("code") String code);
	
	@Query("SELECT a.code, s.name, a.quantity FROM AssignEntity a, SchoolEntity s WHERE s.code LIKE %:code% AND a.code = :code")
	List<Object[]> getListDivideDataView(@Param("code") String code);
	
//	@Query("SELECT SUM(ae.quantity) FROM AssignEntity ae GROUP BY ae.admin.id WHERE ae.admin.id = :id")
//	int getTotalAssignQuantityByAdmin(@Param("id") long id);
}
