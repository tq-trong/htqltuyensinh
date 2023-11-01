package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.input.Input;
import com.cusc.htqltuyensinh.api.output.SchoolOutput;
import com.cusc.htqltuyensinh.dto.SchoolDTO;
import com.cusc.htqltuyensinh.service.ISchoolService;

@CrossOrigin
@RestController
public class SchoolAPI {
	
	@Autowired
	private ISchoolService schoolService;
	
	@GetMapping(value = "/school")
	public SchoolOutput showSchool(@RequestParam("page") int page,
								   @RequestParam("limit") int limit,
								   @ModelAttribute Input input) {
		
		SchoolOutput results = new SchoolOutput();
		results.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, limit);
		results.setListResult(schoolService.findAll(input.getKeyword(), pageable));
		
		long totalItems = schoolService.totalItem(input.getKeyword());
		
		results.setTotalPage(results.setTotalPage(totalItems, limit));
		return results;
	}
	
	@PostMapping(value = "/school")
	public SchoolDTO createSchool(@RequestBody SchoolDTO model) {
		
		return schoolService.save(model);
	}
	
	@PutMapping(value = "/school/{id}")
	public SchoolDTO updateSchool(@RequestBody SchoolDTO model, @PathVariable long id) {
		model.setId(id);
		return schoolService.save(model);
	}
	
	@DeleteMapping(value = "/school")
	public void deleteSchool(@RequestBody long[] ids) {
		schoolService.remove(ids);
	}
}
