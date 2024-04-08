package com.cusc.htqltuyensinh.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.input.Input;
import com.cusc.htqltuyensinh.api.output.AssignDetailOutput;
import com.cusc.htqltuyensinh.api.output.AssignOutput;
import com.cusc.htqltuyensinh.dto.AssignDTO;
import com.cusc.htqltuyensinh.dto.IdDTO;
import com.cusc.htqltuyensinh.service.impl.AssignDetailService;
import com.cusc.htqltuyensinh.service.impl.AssignService;
import com.cusc.htqltuyensinh.service.impl.UserService;

@CrossOrigin
@RestController
public class AssignAPI {

	int LIMIT_ITEMS = 1;

	@Autowired
	private AssignService assignService;

	@Autowired
	private AssignDetailService assignDetailService;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/api/user-school")
	public int countUserBySchool(@RequestBody IdDTO dto) {

		return userService.countUserBySchool(dto.getCode());
	}

	@PostMapping(value = "/api/user-assign")
	public AssignDTO getOneAssign(@RequestBody IdDTO dto) {

		return assignService.findOneByCode(dto.getCode());
	}

	@PostMapping(value = "/api/assigns")
	public List<AssignDTO> getListAssignBySchool(@RequestBody IdDTO dto) {
		return assignService.getListAssignBySchool(dto.getCode());
	}

	@PostMapping(value = "/api/assign")
	public AssignDTO divideData(@RequestBody AssignDTO dto) {

		return assignService.save(dto);
	}

	@PutMapping(value = "/api/assign")
	public AssignDTO assignData(@RequestBody AssignDTO dto) {
		dto.setId(dto.getId());
		return assignService.save(dto);
	}

	@GetMapping(value = "/api/divide-data")
	public AssignDetailOutput showAssigns(@RequestParam("page") int page, @ModelAttribute Input input) {

		AssignDetailOutput result = new AssignDetailOutput();
		result.setPage(page);

		Pageable pageable = PageRequest.of(page - 1, LIMIT_ITEMS);
		result.setListResult(assignDetailService.getListDivideDataView(input.getKeyword(), pageable));

		long totalItems = assignDetailService.totalItem(input.getKeyword());

		result.setTotalPage(result.setTotalPage(totalItems, LIMIT_ITEMS));
		return result;
	}
	
//	@GetMapping(value = "/api/total-assign/{id}")
//	public int getTotalAssign(@PathVariable("id") long id) {
//		return assignService.getTotalAssignQuantity(id);
//	}
}
