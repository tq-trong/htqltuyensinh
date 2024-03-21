package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long>{
	List<NoteEntity> findByAdmin(AdminEntity admin);
}
