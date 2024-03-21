package com.cusc.htqltuyensinh.service;

import java.util.List;

import com.cusc.htqltuyensinh.dto.NoteDTO;

public interface INoteService extends IBaseService<NoteDTO>{
	List<NoteDTO> showAllByAdmin(long id);
	void removeOne(long id);
}
