package com.cusc.htqltuyensinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cusc.htqltuyensinh.dto.AssignDetailDTO;

public interface IAssignDetailService extends IBaseService<AssignDetailDTO>{
	int countUserByAssignCode(String code);
	
	List<AssignDetailDTO> getListDivideDataView(String keyword, Pageable pageable);
}
