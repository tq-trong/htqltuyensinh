package com.cusc.htqltuyensinh.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calls")
public class CallEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "users_id")
    private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "admins_id")
    private AdminEntity admin;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
    private StatusEntity status;
	
	@Column(name = "status_detail")
	private String statusDetail;
	
	@Column(name = "times")
	private Integer times;
	
	@Column(name = "result")
	private String result;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
