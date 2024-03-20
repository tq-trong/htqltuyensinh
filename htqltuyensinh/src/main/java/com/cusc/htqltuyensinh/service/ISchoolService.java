package com.cusc.htqltuyensinh.service;

import java.util.List;

import com.cusc.htqltuyensinh.dto.SchoolDTO;

public interface ISchoolService extends IBaseService<SchoolDTO>{
	List<SchoolDTO> findByProvince(long id);
}
