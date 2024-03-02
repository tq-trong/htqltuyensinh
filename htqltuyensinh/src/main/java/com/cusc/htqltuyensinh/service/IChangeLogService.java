package com.cusc.htqltuyensinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cusc.htqltuyensinh.dto.ChangeLogDTO;

public interface IChangeLogService extends IBaseService<ChangeLogDTO>{
	List<ChangeLogDTO> findLogOfSomeone(String keyword, Pageable pageable, Long adminID);
	long totalItemByAdmin(String keyword, Long adminID);
}
