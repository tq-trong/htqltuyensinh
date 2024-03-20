package com.cusc.htqltuyensinh.service;

import com.cusc.htqltuyensinh.dto.AssignDetailDTO;

public interface IAssignDetailService extends IBaseService<AssignDetailDTO>{
	int countUserByAssignCode(String code);
}
