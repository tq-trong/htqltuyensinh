package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.input.Input;
import com.cusc.htqltuyensinh.api.output.ChangeLogOutput;
import com.cusc.htqltuyensinh.service.IChangeLogService;

@CrossOrigin
@RestController
public class ChangeLogAPI {
	
	@Autowired
	private IChangeLogService changeLogService;
	
	@PostMapping(value = "/change-log")
	public ChangeLogOutput showLog(@RequestParam("page") int page, 
			 @RequestParam("limit") int limit,
			 @ModelAttribute Input input) {
		
		ChangeLogOutput result = new ChangeLogOutput();
		result.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, limit);
		
		result.setListResult(changeLogService.findAll(input.getKeyword(), pageable));
		
		long totalItems = changeLogService.totalItem(input.getKeyword());
		result.setTotalPage(result.setTotalPage(totalItems, limit));
		return result;
	}

}
