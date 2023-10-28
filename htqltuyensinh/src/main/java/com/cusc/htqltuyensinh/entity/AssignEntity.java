package com.cusc.htqltuyensinh.entity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assigns")
public class AssignEntity extends BaseEntity{

	@Column(name = "code")
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "admins_id")
    private AdminEntity admin;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "call_status")
	private Integer callStatus;
	
	@OneToMany(mappedBy = "assign")
    private List<AssignDetailEntity> assignDetails = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(Integer callStatus) {
		this.callStatus = callStatus;
	}

	public List<AssignDetailEntity> getAssignDetails() {
		return assignDetails;
	}

	public void setAssignDetails(List<AssignDetailEntity> assignDetails) {
		this.assignDetails = assignDetails;
	}
}
