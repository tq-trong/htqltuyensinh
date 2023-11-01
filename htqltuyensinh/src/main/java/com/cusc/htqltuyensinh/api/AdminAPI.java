package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
import com.cusc.htqltuyensinh.api.output.AdminOutput;
import com.cusc.htqltuyensinh.api.output.LoginOutput;
import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.service.IAdminService;

@CrossOrigin
@RestController
public class AdminAPI {
	
	@Autowired
	private IAdminService adminService;
	
	@GetMapping(value = "/admin")
	public AdminOutput showAdmin(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit,
								 @ModelAttribute Input input) {
		
		AdminOutput result = new AdminOutput();
		result.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListResult(adminService.findAll(input.getKeyword(), pageable));
		
		long totalItems = adminService.totalItem(input.getKeyword());
		
		result.setTotalPage(result.setTotalPage(totalItems, limit));
		return result;
	}
	
	@PostMapping(value = "/admin")
	public AdminDTO createAdmin(@RequestBody AdminDTO model) {
		return adminService.save(model);
	}
	
	@PutMapping(value = "/admin/{id}")
	public AdminDTO updateAdmin(@RequestBody AdminDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return adminService.save(model);
	}
	
	@DeleteMapping(value = "/admin")
	public void deleteAdmin(@RequestBody long[] ids) {
		adminService.remove(ids);
	}
	
	@PostMapping(value = "/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AdminDTO model) {
		System.out.print("=================>"+ model.getUsername() + model.getPassword());
      LoginOutput output = adminService.login(model);
      return ResponseEntity.ok(output);
    }
}
