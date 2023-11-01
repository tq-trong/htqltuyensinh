package com.cusc.htqltuyensinh.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.api.output.LoginOutput;
import com.cusc.htqltuyensinh.converter.AdminConverter;
import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminConverter adminConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AdminDTO save(AdminDTO dto) {
		AdminEntity adminEntity;
		if (dto.getId() != null) {
			Optional<AdminEntity> adminOptional = adminRepository.findById(dto.getId());
			if (adminOptional.isPresent()) {
				AdminEntity oldAdmin = adminOptional.get();
				adminEntity = adminConverter.toEntity(dto, oldAdmin);
			} else {
				return null;
			}
		} else {
			String enPass = passwordEncoder.encode(dto.getPassword());
			adminEntity = adminConverter.toEntity(dto);
			adminEntity.setPassword(enPass);
		}
		adminRepository.save(adminEntity);
		return adminConverter.toDTO(adminEntity);
	}

	@Override
	public List<AdminDTO> findAll(String keyword, Pageable pageable) { // Get list Admin
		List<AdminEntity> entities;
		if (keyword != null && !keyword.isEmpty()) {
			entities = adminRepository.findByNameContaining(keyword, pageable);
			if (entities.isEmpty() || entities == null) {
				entities = adminRepository.findByCodeContaining(keyword, pageable);
			}
		} else {
			entities = adminRepository.findAll(pageable).getContent();
		}
		List<AdminDTO> results = entities.stream().map(adminConverter::toDTO).collect(Collectors.toList());
		return results;
	}

	@Override
	public void remove(long[] ids) {
		for (long item : ids) {
			adminRepository.deleteById(item);
		}
	}

	@Override
	public int totalItem(String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
			return adminRepository.countByNameContaining(keyword);
		}
		return (int) adminRepository.count();
	}

	@Override
	public LoginOutput login(AdminDTO dto) {
		AdminEntity entity = adminRepository.findByUsername(dto.getUsername());
		if (entity != null) {
			String password = dto.getPassword();
			String encodePass = entity.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodePass);
			if (isPwdRight) {
				Optional<AdminEntity> adminEntity = adminRepository.findOneByUsernameAndPassword(dto.getUsername(),
						encodePass);
				if (adminEntity.isPresent()) {
					return new LoginOutput(adminConverter.toDTO(entity), true);
				} else {
					return new LoginOutput(null, false);
				}
			} else {
				return new LoginOutput(null, false);
			}
		}
		return new LoginOutput(null, false);
	}

//	@Override
//    public UserDetails loadUserByUsername(String username) {
//        try {
//        	username="test";
//            AdminEntity entity = adminRepository.findByUsername(username);
//            if (entity == null) {
//                throw new UsernameNotFoundException("Không tìm thấy người dùng");
//            }
//
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            if (entity.isRole()) {
//                authorities.add(new SimpleGrantedAuthority("ADMIN"));
//            } else {
//                authorities.add(new SimpleGrantedAuthority("USERMANAGER"));
//            }
//            System.out.print("===================> " +entity.getPassword());
//            System.out.print("===================> " + username);
//            return new org.springframework.security.core.userdetails.User(entity.getUsername(), entity.getPassword(), authorities);
//        } catch (Exception e) {
//        	System.out.print(username);
//            // Xử lý ngoại lệ và ghi log (nếu cần)
//            throw new UsernameNotFoundException("Không thể tìm người dùng: " + e.getMessage(), e);
//        }
//    }
}
