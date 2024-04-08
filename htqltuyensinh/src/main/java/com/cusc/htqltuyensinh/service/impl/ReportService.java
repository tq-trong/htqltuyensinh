package com.cusc.htqltuyensinh.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.cusc.htqltuyensinh.dto.LoginTimeDTO;
import com.cusc.htqltuyensinh.entity.AdminEntity;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.repository.ReportRepository;
import com.cusc.htqltuyensinh.service.IAdminService;
import com.cusc.htqltuyensinh.service.IReportService;

@Service
public class ReportService implements IReportService {
	@Autowired
	private ReportRepository reportRepository;

	@Override
	public void remove(long[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> getListDivideDataView() {
		List<Object[]> results = reportRepository.getListDivideDataView();
		List<Map<String, Object>> data = new ArrayList<>();
		float total;
		for (Object[] result : results) {
			Map<String, Object> row = new HashMap<>();
			row.put("labels", result[0]);
			total = Float.parseFloat(String.format("%.1f", result[1]));
			row.put("data", total);
			// Thêm các cặp key-value khác tùy thuộc vào số trường bạn cần
			data.add(row);
		}
		return data;
	}

	@Override
	public int totalItem(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LoginTimeDTO> findAll(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginTimeDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginTimeDTO save(LoginTimeDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> test() {
		List<Object[]> results = reportRepository.test();
		List<Map<String, Object>> data = new ArrayList<>();
		boolean checkAddData = false;
		for (int i = 0; i < results.size(); i++) {
			Map<String, Object> row = new HashMap<>();
			row.put("id", results.get(i)[0]);
			row.put("name", results.get(i)[1]);
			row.put("code", results.get(i)[2]);
			if (data.size() > 0) {
				row.put("quantity", results.get(i)[3]);
				for (int j = 0; j < data.size(); j++) {
					row.put("time1", 0);
					row.put("time2", 0);
					row.put("time3", 0);
					if (data.get(j).get("code").equals(row.get("code"))) {
						if (Integer.parseInt(results.get(i)[3].toString()) != 0) {
							if (Integer.parseInt(results.get(i)[4].toString()) == 1) {
								data.get(j).replace("time1", results.get(i)[5]);
							} else if (Integer.parseInt(results.get(i)[4].toString()) == 2) {
								data.get(j).replace("time2", results.get(i)[5]);
							} else if (Integer.parseInt(results.get(i)[4].toString()) == 3) {
								data.get(j).replace("time3", results.get(i)[5]);
							}
						}
						checkAddData = false;
					} else {
						if (Integer.parseInt(results.get(i)[3].toString()) != 0) {
							if (Integer.parseInt(results.get(i)[4].toString()) == 1) {
								row.replace("time1", results.get(i)[5]);
							} else if (Integer.parseInt(results.get(i)[4].toString()) == 2) {
								row.replace("time2", results.get(i)[5]);
							} else if (Integer.parseInt(results.get(i)[4].toString()) == 3) {
								row.replace("time3", results.get(i)[5]);
							}
						}
						checkAddData = true;
					}
				}
				if (checkAddData)
					data.add(row);
			} else {
				row.put("quantity", results.get(i)[3]);
				for (int t = 1; t <= 3; t++) {
					if (Integer.parseInt(results.get(i)[3].toString()) == 0) {
						row.put("time" + t, 0);
					} else {
						if (t == Integer.parseInt(results.get(i)[3].toString())) {
							row.put("time" + t, results.get(i)[5]);
						} else
							row.put("time" + t, 0);
					}
				}
				data.add(row);
			}
		}
		return data;
	}

}
