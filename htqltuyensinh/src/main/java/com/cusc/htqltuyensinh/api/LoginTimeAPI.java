package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.input.Input;
import com.cusc.htqltuyensinh.api.output.LoginTimeOutput;
import com.cusc.htqltuyensinh.dto.LoginTimeDTO;
import com.cusc.htqltuyensinh.service.impl.LoginTimeService;

@CrossOrigin
@RestController
public class LoginTimeAPI {
	
	int LIMIT_ITEMS = 10;

	@Autowired
	private LoginTimeService loginTimeService;

	@PostMapping(value = "/api/login-time")
	public LoginTimeDTO createLoginTime(@RequestBody LoginTimeDTO model) {
		return loginTimeService.save(model);
	}
	
	@PutMapping(value = "/api/login-time")
	public LoginTimeDTO updateAdmin(@RequestBody LoginTimeDTO model) {
		model.setId(model.getId());
		return loginTimeService.save(model);
	}
	
	@GetMapping(value = "/api/login-time")
	public LoginTimeOutput showLog(@RequestParam("page") int page, 
			 @ModelAttribute Input input) {
		
		LoginTimeOutput result = new LoginTimeOutput();
		result.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, LIMIT_ITEMS);
		
		result.setListResult(loginTimeService.findAll(input.getKeyword(), pageable));
		
		long totalItems = loginTimeService.totalItem(input.getKeyword());
		result.setTotalPage(result.setTotalPage(totalItems, LIMIT_ITEMS));
		return result;
	}
}
