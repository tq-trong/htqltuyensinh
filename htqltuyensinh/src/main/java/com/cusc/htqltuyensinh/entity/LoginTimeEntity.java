package com.cusc.htqltuyensinh.entity;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_time")
public class LoginTimeEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "admins_id")
    private AdminEntity admin;
	
	@Column(name = "start")
	private Timestamp start;
	
	@Column(name = "end")
	private Timestamp end;
	
	@Column(name = "total_time")
	private Float totalTime;

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public Float getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Float totalTime) {
		this.totalTime = totalTime;
	}

}
