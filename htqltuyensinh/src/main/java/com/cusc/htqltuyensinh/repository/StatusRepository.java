package com.cusc.htqltuyensinh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cusc.htqltuyensinh.entity.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Long>{

	@Query(value = "SELECT name, tong, (SELECT SUM(tong) FROM ( " +
            "SELECT s.name, COALESCE(COUNT(c.users_id), 0) as tong " +
            "FROM ( " +
            "SELECT users_id, MAX(times) as max_times " +
            "FROM calls " +
            "GROUP BY users_id) as max_times_from_calls " +
            "LEFT JOIN calls c ON c.users_id = max_times_from_calls.users_id AND c.times = max_times_from_calls.max_times " +
            "RIGHT JOIN status s ON c.status_id = s.id " +
            "GROUP BY s.name) AS subquery) AS total_tong " +
            "FROM ( " +
            "SELECT s.name, COALESCE(COUNT(c.users_id), 0) as tong " +
            "FROM ( " +
            "SELECT users_id, MAX(times) as max_times " +
            "FROM calls " +
            "GROUP BY users_id) as max_times_from_calls " +
            "LEFT JOIN calls c ON c.users_id = max_times_from_calls.users_id AND c.times = max_times_from_calls.max_times " +
            "RIGHT JOIN status s ON c.status_id = s.id " +
            "GROUP BY s.name) AS main_query", nativeQuery = true)
	List<Object[]> getStatusCountsAndTotal();
}
