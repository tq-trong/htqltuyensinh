package com.cusc.htqltuyensinh.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import org.springframework.web.multipart.MultipartFile;

import com.cusc.htqltuyensinh.api.input.Input;
import com.cusc.htqltuyensinh.api.output.UserOutput;
import com.cusc.htqltuyensinh.dto.UserDTO;
import com.cusc.htqltuyensinh.service.IUserService;

@CrossOrigin
@RestController
public class UserAPI {

	int LIMIT_ITEMS = 10;

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/api/data")
	public UserOutput showUser(@RequestParam("page") int page, @ModelAttribute Input input) {

		UserOutput result = new UserOutput();
		result.setPage(page);

		Pageable pageable = PageRequest.of(page - 1, LIMIT_ITEMS);
		result.setListResult(userService.findAll(input.getKeyword(), pageable));

		long totalItems = userService.totalItem(input.getKeyword());

		result.setTotalPage(result.setTotalPage(totalItems, LIMIT_ITEMS));
		return result;
	}

	@PostMapping(value = "/api/users")
	public ResponseEntity<List<UserDTO>> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            List<UserDTO> savedUsers = userService.processExcelAndSave(file);
            return ResponseEntity.ok().body(savedUsers);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

	@PutMapping(value = "/user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return userService.save(model);
	}

	@DeleteMapping(value = "/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.remove(ids);
	}
}
