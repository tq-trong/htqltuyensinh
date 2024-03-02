package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.input.Input;
import com.cusc.htqltuyensinh.api.output.ChangeLogOutput;
import com.cusc.htqltuyensinh.service.IChangeLogService;

@CrossOrigin
@RestController
public class ChangeLogAPI {
	
	int LIMIT_ITEMS = 1;
	
	@Autowired
	private IChangeLogService changeLogService;
	
	@GetMapping(value = "/api/change-log")
	public ChangeLogOutput showLog(@RequestParam("page") int page, 
			 @ModelAttribute Input input) {
		
		ChangeLogOutput result = new ChangeLogOutput();
		result.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, LIMIT_ITEMS);
		
		result.setListResult(changeLogService.findAll(input.getKeyword(), pageable));
		
		long totalItems = changeLogService.totalItem(input.getKeyword());
		result.setTotalPage(result.setTotalPage(totalItems, LIMIT_ITEMS));
		return result;
	}
	
	@GetMapping(value = "/api/change-log/{id}")
	public ChangeLogOutput showLogSomeone(@RequestParam("page") int page, @PathVariable("id") long id,
			 @ModelAttribute Input input) {
		
		ChangeLogOutput result = new ChangeLogOutput();
		result.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, LIMIT_ITEMS);
		
		result.setListResult(changeLogService.findLogOfSomeone(input.getKeyword(), pageable, id));
		
		long totalItems = changeLogService.totalItemByAdmin(input.getKeyword(), id);
		result.setTotalPage(result.setTotalPage(totalItems, LIMIT_ITEMS));
		return result;
	}

}
