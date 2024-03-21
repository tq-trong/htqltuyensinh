package com.cusc.htqltuyensinh.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class NoteEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "admins_id")
    private AdminEntity admin;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "status")
	private boolean status;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
