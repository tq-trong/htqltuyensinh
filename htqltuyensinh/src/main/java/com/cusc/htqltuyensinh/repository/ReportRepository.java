package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cusc.htqltuyensinh.entity.AdminEntity;

public interface ReportRepository extends JpaRepository<AdminEntity, Long>, BaseRepository<AdminEntity> {
	@Query("SELECT ade.name, SUM(lte.totalTime) FROM LoginTimeEntity lte JOIN AdminEntity ade ON lte.admin.id = ade.id GROUP BY lte.admin.id")
	List<Object[]> getListDivideDataView();

	@Query("SELECT ad.id, ad.name, ad.code, COUNT(DISTINCT asd.user.id), c.times, COUNT(DISTINCT c.user.id)" + 
			" FROM CallEntity c" + 
			" RIGHT JOIN AssignEntity asg ON asg.admin.id = c.admin.id" + 
			" RIGHT JOIN AssignDetailEntity asd on asd.assign.id = asg.id" + 
			" RIGHT JOIN AdminEntity ad on ad.id = asg.admin.id " +
			" WHERE ad.role = 0" +
			" GROUP BY asg.admin.id, c.times")
	List<Object[]> test();

}
