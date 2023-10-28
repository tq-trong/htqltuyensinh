package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface BaseRepository<T> {
	
	List<T> findByNameContaining(String keyword, Pageable pageable);

	int countByNameContaining(String keyword);
}
