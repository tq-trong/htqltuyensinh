package com.cusc.htqltuyensinh.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.api.output.CustomUserDetails;
import com.cusc.htqltuyensinh.converter.AdminConverter;
import com.cusc.htqltuyensinh.dto.AdminDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.service.IAdminService;

@Service
public class AdminService implements IAdminService, UserDetailsService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminConverter adminConverter;
	
	@Autowired
    private AuthenticationManager authenticationManager;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity admin = adminRepository.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(admin.isRole() ? "ADMIN" : "USERMANAGER"));

        return new CustomUserDetails(
                admin.getCode(),
                admin.getName(),
                admin.getBirthday(),
                admin.getUsername(),
                admin.getPassword(),
                admin.isGender(),
                admin.getPhone(),
                admin.getAddress(),
                admin.getEmail(),
                admin.isRole(),
                admin.isStatus(),
                authorities
            );
    }
	
	public void login(AdminDTO dto, HttpServletResponse response) {
	    try {
	        Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	    } catch (AuthenticationException e) {
	        // Xử lý trường hợp xác thực không thành công
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        try {
	            response.getWriter().write("Authentication failed");
	        } catch (IOException ioException) {
	            // Xử lý lỗi khi ghi vào response
	            ioException.printStackTrace();
	        }
	    }
	}

	@Override
	public AdminDTO findById(long id) {
		AdminEntity adminEntity;
	    Optional<AdminEntity> adminOptional = adminRepository.findById(id);
	    adminEntity = adminOptional.get();
	    return adminConverter.toDTO(adminEntity);
	}
}
