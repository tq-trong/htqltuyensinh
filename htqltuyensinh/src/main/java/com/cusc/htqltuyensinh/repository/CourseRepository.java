package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>, BaseRepository<CourseEntity>{
	List<CourseEntity> findByCodeContaining(String keyword, Pageable pageable);
	int countByCodeContaining(String keyword);
}
