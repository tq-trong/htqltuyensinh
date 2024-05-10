package com.cusc.htqltuyensinh.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.service.IStatusService;

@CrossOrigin
@RestController
public class StatusAPI {
	@Autowired
	private IStatusService statusService;
	
	@GetMapping(value = "/api/list-status-and-count")
	public List<Object[]> getListStatusAndCount() {
		return statusService.getAllStatusAndCount();
	}
}
