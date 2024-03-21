package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.output.MissCallOutput;
import com.cusc.htqltuyensinh.dto.MissCallDTO;
import com.cusc.htqltuyensinh.service.IMissCallService;

@CrossOrigin
@RestController
public class MissCallAPI {
	@Autowired
	private IMissCallService missCallService;
	
	@GetMapping(value = "/api/misscalls")
	public MissCallOutput showMissCalls() {
		MissCallOutput result = new MissCallOutput();
		
		result.setListResult(missCallService.showAll());
		
		return result;
	}
	
	@PostMapping(value = "/api/misscalls")
	public MissCallDTO createMissCall(@RequestBody MissCallDTO model) {
		return missCallService.save(model);
	}
	
	@DeleteMapping(value = "/api/misscalls/{id}")
	public void deleteMissCall(@PathVariable long id) {
		missCallService.removeOne(id);
	}
}
