package com.cusc.htqltuyensinh.entity;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assign_details")
public class AssignDetailEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "assigns_id")
    private AssignEntity assign;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
    private UserEntity user;

	public AssignEntity getAssign() {
		return assign;
	}

	public void setAssign(AssignEntity assign) {
		this.assign = assign;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
