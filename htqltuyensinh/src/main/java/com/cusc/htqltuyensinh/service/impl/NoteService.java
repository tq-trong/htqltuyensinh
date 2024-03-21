package com.cusc.htqltuyensinh.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.NoteConverter;
import com.cusc.htqltuyensinh.dto.NoteDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.NoteEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.repository.NoteRepository;
import com.cusc.htqltuyensinh.service.INoteService;

@Service
public class NoteService implements INoteService{
	@Autowired
	private NoteConverter noteConverter;
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public int totalItem(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoteDTO> findAll(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoteDTO save(NoteDTO dto) {
		NoteEntity entity = noteConverter.toEntity(dto);
		noteRepository.save(entity);
		
		return noteConverter.toDTO(entity);
	}

	@Override
	public void remove(long[] ids) {
		for (long item : ids) {
			noteRepository.deleteById(item);
		}
	}

	@Override
	public List<NoteDTO> showAllByAdmin(long id) {
		List<NoteEntity> listEntity;
		Optional<AdminEntity> adminOptional = adminRepository.findById(id);
		AdminEntity adminEntity = adminOptional.get();
		
		listEntity = noteRepository.findByAdmin(adminEntity);
		
		List<NoteDTO> results = listEntity.stream().map(noteConverter::toDTO).collect(Collectors.toList());
		Collections.reverse(results);
		return results;
	}

	@Override
	public void removeOne(long id) {
		noteRepository.deleteById(id);
	}

}
