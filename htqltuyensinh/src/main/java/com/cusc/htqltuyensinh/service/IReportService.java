package com.cusc.htqltuyensinh.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.dto.LoginTimeDTO;

public interface IReportService extends IBaseService<LoginTimeDTO>{
	List<Map<String, Object>> getListDivideDataView();
	
	List<Map<String, Object>> test();
}
