package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cusc.htqltuyensinh.entity.CallEntity;

public interface CallRepository extends JpaRepository<CallEntity, Long> {
	@Query("SELECT ad.id, ad.name, ad.code, COUNT(DISTINCT asd.user.id), c.times, COUNT(DISTINCT c.user.id)" + 
			" FROM CallEntity c" + 
			" RIGHT JOIN AssignEntity asg ON asg.admin.id = c.admin.id" + 
			" RIGHT JOIN AssignDetailEntity asd on asd.assign.id = asg.id" + 
			" RIGHT JOIN AdminEntity ad on ad.id = asg.admin.id " +
			" WHERE ad.role = 0" +
			" GROUP BY asg.admin.id, c.times")
	List<Object[]> countByAdminAndTimes();
}
