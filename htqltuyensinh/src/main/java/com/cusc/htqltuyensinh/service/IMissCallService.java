package com.cusc.htqltuyensinh.service;

import java.util.List;

import com.cusc.htqltuyensinh.dto.MissCallDTO;

public interface IMissCallService extends IBaseService<MissCallDTO>{
	List<MissCallDTO> showAll();
	List<MissCallDTO> showByUserManager(long id);
	void removeOne(long id);
}
