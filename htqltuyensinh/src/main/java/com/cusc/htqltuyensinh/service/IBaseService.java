package com.cusc.htqltuyensinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface IBaseService<T> {
	int totalItem(String keyword);
	List<T> findAll(String keyword, Pageable pageable);
	T findById(long id);
	T save(T dto);
	void remove(long[] ids);
}
