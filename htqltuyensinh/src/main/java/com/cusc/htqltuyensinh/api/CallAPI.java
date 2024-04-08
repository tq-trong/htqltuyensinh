package com.cusc.htqltuyensinh.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.service.ICallService;

@CrossOrigin
@RestController
public class CallAPI {
	@Autowired
	private ICallService callService;

	@GetMapping(value = "/api/calls/count")
	public List<Map<String, Object>> countCallsByAdminAndTimes() {

		return callService.countByTimesAndAdmin();
	}
}
