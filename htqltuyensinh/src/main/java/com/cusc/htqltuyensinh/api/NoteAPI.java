package com.cusc.htqltuyensinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cusc.htqltuyensinh.api.output.NoteOutput;
import com.cusc.htqltuyensinh.dto.NoteDTO;
import com.cusc.htqltuyensinh.service.INoteService;

@CrossOrigin
@RestController
public class NoteAPI {
	@Autowired
	private INoteService noteService;
	
	@GetMapping(value = "/api/notes/{id}")
	public NoteOutput showNotes(@PathVariable long id) {
		NoteOutput result = new NoteOutput();
		result.setListResult(noteService.showAllByAdmin(id));
		
		return result;
	}
	
	@PostMapping(value = "/api/notes")
	public NoteDTO createNote(@RequestBody NoteDTO model) {
		return noteService.save(model);
	}
	
	@DeleteMapping(value = "/api/notes/{id}")
	public void deleteNote(@PathVariable long id) {
		noteService.removeOne(id);
	}
}
