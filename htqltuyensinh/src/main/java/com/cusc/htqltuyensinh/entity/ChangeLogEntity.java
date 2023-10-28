package com.cusc.htqltuyensinh.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "change_logs")
public class ChangeLogEntity extends BaseEntity{
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time")
	private Date time = new Date();
	
	@ManyToOne
	@JoinColumn(name = "admins_id")
    private AdminEntity admin;
	
	@Column(name = "description")
	private String description;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
