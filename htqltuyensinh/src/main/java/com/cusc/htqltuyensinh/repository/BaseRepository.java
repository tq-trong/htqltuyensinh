package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface BaseRepository<T> {
	
	List<T> findByNameContaining(String keyword, Pageable pageable);
	//T findById(long id);
	int countByNameContaining(String keyword);
}
