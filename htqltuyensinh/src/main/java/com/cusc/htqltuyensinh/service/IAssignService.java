package com.cusc.htqltuyensinh.service;

import java.util.List;

import com.cusc.htqltuyensinh.dto.AssignDTO;

public interface IAssignService extends IBaseService<AssignDTO>{
	int countByCode(String code);
	List<AssignDTO> getListAssignBySchool(String code);
	AssignDTO findOneByCode(String code);
	List<Object[]> getListDivideDataView(String code);
	
//	int getTotalAssignQuantity(long admin);
}
