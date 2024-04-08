package com.cusc.htqltuyensinh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cusc.htqltuyensinh.converter.AdminConverter;
import com.cusc.htqltuyensinh.repository.AdminRepository;
import com.cusc.htqltuyensinh.repository.CallRepository;
import com.cusc.htqltuyensinh.service.ICallService;

@Service
public class CallService implements ICallService {
	@Autowired
	private CallRepository callRepository;

	@Autowired
	private AdminConverter adminConverter;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Map<String, Object>> countByTimesAndAdmin() {
		List<Object[]> results = callRepository.countByAdminAndTimes();
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
