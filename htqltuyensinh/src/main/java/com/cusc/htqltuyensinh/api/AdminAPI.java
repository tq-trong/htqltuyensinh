package com.cusc.htqltuyensinh.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.cusc.htqltuyensinh.api.output.CustomUserDetails;
import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.dto.IdDTO;
import com.cusc.htqltuyensinh.dto.PasswordDTO;
import com.cusc.htqltuyensinh.service.impl.AdminService;

@CrossOrigin
@RestController
public class AdminAPI {
	
	int LIMIT_ITEMS = 10;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@GetMapping(value = "/api/admins")
	public AdminOutput showAdmins(@RequestParam("page") int page, 
								 @ModelAttribute Input input) {
		
		AdminOutput result = new AdminOutput();
		result.setPage(page);
		
		Pageable pageable = PageRequest.of(page - 1, LIMIT_ITEMS);
		result.setListResult(adminService.findAll(input.getKeyword(), pageable));
		
		long totalItems = adminService.totalItem(input.getKeyword());
		
		result.setTotalPage(result.setTotalPage(totalItems, LIMIT_ITEMS));
		return result;
	}
	
	@GetMapping(value = "/api/admins/{id}")
	public AdminOutput showAdmin(@PathVariable("id") long id) {
		AdminOutput result = new AdminOutput();
		result.setAdmin(adminService.findById(id));
		return result;
	}
	
	@PostMapping(value = "/api/admins")
	public AdminDTO createAdmin(@RequestBody AdminDTO model) {
		return adminService.save(model);
		
	}
	
	@PostMapping(value = "/api/admins/checkPass/{id}")
	public boolean checkPassword(@PathVariable("id") long id, @RequestBody PasswordDTO passwordDTO) {
		String password = passwordDTO.getPassword();
		return adminService.checkPass(id, password);
	}
	
	@PutMapping(value = "/api/admins/{id}")
	public AdminDTO updateAdmin(@RequestBody AdminDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return adminService.save(model);
	}
	
	@DeleteMapping(value = "/admin")
	public void deleteAdmin(@RequestBody long[] ids) {
		adminService.remove(ids);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<CustomUserDetails> login(@RequestBody AdminDTO model) {
	    try {
	        Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword())
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
	        // Tạo một đối tượng JSON chứa thông tin người dùng và trả về
	        return ResponseEntity.ok(userDetails);

	    } catch (AuthenticationException e) {
	        // Xử lý trường hợp xác thực không thành công
	        CustomUserDetails failedOutput = new CustomUserDetails(
	        	0,
	            null, // code
	            null, // name
	            null, // birthday
	            model.getUsername(), // username
	            null, // password
	            false, // gender
	            null, // phone
	            null, // address
	            null, // email
	            false, // role
	            false, // status
	            Collections.emptyList()  // authorities
	        );
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failedOutput);
	    }
	}
	@PostMapping(value = "/api/user-manager")
	public AdminDTO getUserManager(@RequestBody IdDTO dto) {
		return adminService.findById(dto.getId());
	}
	
	@PostMapping(value = "/api/admin-role")
	public List<AdminDTO> getListAdminByRole(@RequestBody IdDTO dto) {
		return adminService.getListAdminByRole(dto.isCheck());
	}
	
	@GetMapping(value = "/api/usermanagers")
	public List<AdminDTO> showUsermanager() {
		return adminService.getListAdminByRole(false);
	}
}
