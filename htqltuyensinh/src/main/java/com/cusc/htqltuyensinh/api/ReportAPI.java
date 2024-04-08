package com.cusc.htqltuyensinh.api;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
import com.cusc.htqltuyensinh.service.impl.ReportService;

@CrossOrigin
@RestController
public class ReportAPI {
	
	int LIMIT_ITEMS = 10;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	
	@GetMapping(value = "/api/reports")
	public List<Map<String, Object>> test() {
		
		return reportService.getListDivideDataView();
	}

	@GetMapping(value = "/api/reportss")
	public List<Map<String, Object>> test1() {
		
		return reportService.test();
	}
	
}
