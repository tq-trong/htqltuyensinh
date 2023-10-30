package com.cusc.htqltuyensinh.dto;

public abstract class BaseDTO<T> {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
