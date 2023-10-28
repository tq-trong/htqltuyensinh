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
import com.cusc.htqltuyensinh.api.output.CourseOutput;
import com.cusc.htqltuyensinh.dto.CourseDTO;
import com.cusc.htqltuyensinh.service.ICourseService;

@CrossOrigin
@RestController
public class CourseAPI {
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping(value = "/course")
	public CourseOutput showCourse(@RequestParam("page") int page,
			   @RequestParam("limit") int limit,
			   @ModelAttribute Input input) {
		
		CourseOutput result = new CourseOutput();
		result.setPage(page);
		
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(courseService.findAll(input.getKeyword(), pageable));
		
		long totalItems = courseService.totalItem(input.getKeyword());
		result.setTotalPage(result.setTotalPage(totalItems, limit));
		return result;
	}
	
	@PostMapping(value = "/course")
	public CourseDTO createCourse(@RequestBody CourseDTO model) {
		return courseService.save(model);
	}
	
	@PutMapping(value = "/course/{id}")
	public CourseDTO updateCourse(@RequestBody CourseDTO model, @PathVariable("id") long id) {
		model.setId(id);
		
		return courseService.save(model);
	}
	
	@DeleteMapping(value = "/course")
	public void deleteCourse(long[] ids) {
		courseService.remove(ids);
	}
}
